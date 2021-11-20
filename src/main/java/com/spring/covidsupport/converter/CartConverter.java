package com.spring.covidsupport.converter;

import com.spring.covidsupport.dto.CartDTO;
import com.spring.covidsupport.entity.Cart;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {
    @Autowired
    private ModelMapper mapper;

    public Cart toEntity(CartDTO dto) {
        Cart entity = mapper.map(dto, Cart.class);
        return entity;
    }

    public CartDTO toDTO(Cart entity) {
        CartDTO dto = mapper.map(entity, CartDTO.class);
        return dto;
    }
}
