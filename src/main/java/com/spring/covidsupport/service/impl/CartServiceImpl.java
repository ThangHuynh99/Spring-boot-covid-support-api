package com.spring.covidsupport.service.impl;

import com.spring.covidsupport.constant.OrderConstant;
import com.spring.covidsupport.constant.ReadConstant;
import com.spring.covidsupport.converter.CartConverter;
import com.spring.covidsupport.dto.CartDTO;
import com.spring.covidsupport.dto.LocationFiltterRequest;
import com.spring.covidsupport.entity.Cart;
import com.spring.covidsupport.entity.Notification;
import com.spring.covidsupport.repository.CartRepository;
import com.spring.covidsupport.repository.NotificationRepository;
import com.spring.covidsupport.response.MessageResponse;
import com.spring.covidsupport.service.CartService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private CartConverter cartConverter;


    @Override
    public Cart save(CartDTO dto) {
        Cart cart = cartConverter.toEntity(dto);
        cart.setStatus(OrderConstant.IN_PROGRESS);
        cart.setCartCode(generateCode());
        cart = cartRepository.save(cart);
        saveNotification(cart);
        return cart;
    }

    @Override
    public ResponseEntity<?> updateCartStatus(long id, int status) {
        Cart cart = cartRepository.getById(id);
        if(cart == null) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Cart not found"));
        }
        cart.setStatus(status);
        return ResponseEntity.ok().body(cartRepository.save(cart));
    }

    @Override
    public Cart getOne(long id) {
        return cartRepository.getById(id);
    }

    @Override
    public List<Cart> getByUser(long id) {
        return cartRepository.findByUserCart(id);
    }

    @Override
    public List<Cart> getByDistination(LocationFiltterRequest location) {
        return cartRepository.findByWardNameAndGroupNumberAndDistrict(location.getWardName(), location.getGroupNumber(), location.getDistrict());
    }

    private String generateCode() {
        int length = 15;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }

    private void saveNotification(Cart cart) {
        Notification notification = Notification.newInstance();
        notification.setCode(cart.getCartCode());
        notification.setOrderId(cart.getId());
        notification.setOwnerName(cart.getOwnerName());
        notification.setRead(ReadConstant.UNREAD);
        notificationRepository.save(notification);
    }
}
