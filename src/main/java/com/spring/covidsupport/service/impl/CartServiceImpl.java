package com.spring.covidsupport.service.impl;

import com.spring.covidsupport.constant.OrderConstant;
import com.spring.covidsupport.constant.ReadConstant;
import com.spring.covidsupport.converter.CartConverter;
import com.spring.covidsupport.converter.ProductOrderConverter;
import com.spring.covidsupport.dto.CartDTO;
import com.spring.covidsupport.dto.LocationFiltterRequest;
import com.spring.covidsupport.dto.ProductOrderDTO;
import com.spring.covidsupport.entity.Cart;
import com.spring.covidsupport.entity.Notification;
import com.spring.covidsupport.entity.Product;
import com.spring.covidsupport.entity.ProductOrder;
import com.spring.covidsupport.repository.CartRepository;
import com.spring.covidsupport.repository.NotificationRepository;
import com.spring.covidsupport.repository.ProductOrderRepository;
import com.spring.covidsupport.repository.ProductRepository;
import com.spring.covidsupport.response.MessageResponse;
import com.spring.covidsupport.service.CartService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private ProductOrderRepository productOrderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartConverter cartConverter;
    @Autowired
    private ProductOrderConverter productOrderConverter;


    @Override
    public Cart save(CartDTO dto) {
        Cart cart = cartConverter.toEntity(dto);
        cart.setStatus(OrderConstant.IN_PROGRESS);
        cart.setCartCode(generateCode());
        cart = cartRepository.save(cart);
        List<ProductOrder> productOrderResult = new ArrayList<>();
        for(ProductOrderDTO data: dto.getListProduct()) {
            ProductOrder entity = productOrderConverter.toEntity(data);
            entity.setCart(cart);
            productOrderResult.add(productOrderRepository.save(entity));
        }
        saveNotification(cart);
        downQuantityProduct(dto);
        cart.setProductOrders(productOrderResult);
        return cart;
    }

    @Override
    public ResponseEntity<?> updateCartStatus(long id, int status) {
        Cart cart = cartRepository.getById(id);
        if(cart == null) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Cart not found"));
        }
        cart.setStatus(status);
        if (status == OrderConstant.CANCEL) {
            upQuantityProduct(cart.getProductOrders());
        }
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
        notification.setReadNoti(ReadConstant.UNREAD) ;
        notificationRepository.save(notification);
    }

    /**
     * this function use when user confirm order product
     * update quatity for product
     * @param cartDTO
     */
    private void downQuantityProduct(CartDTO cartDTO) {
        for (ProductOrderDTO data: cartDTO.getListProduct()) {
            Product product = productRepository.getById(data.getProductId());
            product.setQuantity(product.getQuantity() - data.getQuantity());
            productRepository.save(product);
        }
    }

    /**
     * this function use when user cancel order product
     * update quatity for product
     * @param productOrders
     */
    private void upQuantityProduct(List<ProductOrder> productOrders) {
        for (ProductOrder data: productOrders) {
            Product product = productRepository.getById(data.getProductId());
            product.setQuantity(product.getQuantity() + data.getQuantity());
            productRepository.save(product);
        }
    }
}
