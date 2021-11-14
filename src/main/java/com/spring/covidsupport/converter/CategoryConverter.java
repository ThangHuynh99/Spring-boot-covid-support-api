package com.spring.covidsupport.converter;

import com.spring.covidsupport.dto.CategoryDTO;
import com.spring.covidsupport.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    @Autowired
    private ModelMapper mapper;

    public Category toEntity(CategoryDTO dto) {
        Category entity = mapper.map(dto, Category.class);
        return entity;
    }

    public CategoryDTO toDTO(Category entity) {
        CategoryDTO dto = mapper.map(entity, CategoryDTO.class);
        return dto;
    }
}
