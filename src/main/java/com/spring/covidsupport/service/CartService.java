package com.spring.covidsupport.service;

import com.spring.covidsupport.dto.CartDTO;
import com.spring.covidsupport.dto.LocationFiltterRequest;
import com.spring.covidsupport.entity.Cart;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartService {
    Cart save(CartDTO dto);
    ResponseEntity<?> updateCartStatus(long id, int status);
    Cart getOne(long id);
    List<Cart> getByUser(long id);
    List<Cart> getByDistination(LocationFiltterRequest location);
}
