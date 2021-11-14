package com.spring.covidsupport.converter;

import com.spring.covidsupport.dto.ProductDTO;
import com.spring.covidsupport.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
  @Autowired private ModelMapper mapper;

  public Product toEntity(ProductDTO dto) {
    Product entity = mapper.map(dto, Product.class);
    return entity;
  }

  public ProductDTO toDTO(Product entity) {
    ProductDTO dto = mapper.map(entity, ProductDTO.class);
    return dto;
  }
}
