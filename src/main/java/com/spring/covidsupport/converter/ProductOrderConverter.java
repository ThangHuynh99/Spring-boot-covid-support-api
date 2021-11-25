package com.spring.covidsupport.converter;

import com.spring.covidsupport.dto.ProductOrderDTO;
import com.spring.covidsupport.entity.ProductOrder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductOrderConverter {
    @Autowired
    private ModelMapper mapper;

    public ProductOrder toEntity(ProductOrderDTO dto) {
        return mapper.map(dto, ProductOrder.class);
    }

    public ProductOrderDTO toDTO(ProductOrder entity) {
        return mapper.map(entity, ProductOrderDTO.class);
    }
}
