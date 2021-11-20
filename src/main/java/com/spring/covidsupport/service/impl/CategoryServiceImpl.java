package com.spring.covidsupport.service.impl;

import com.spring.covidsupport.converter.CategoryConverter;
import com.spring.covidsupport.dto.CategoryDTO;
import com.spring.covidsupport.entity.Category;
import com.spring.covidsupport.repository.CategoryRepository;
import com.spring.covidsupport.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
  @Autowired private CategoryRepository categoryRepository;
  @Autowired private CategoryConverter categoryConverter;

  @Override
  public CategoryDTO save(CategoryDTO category) {
    Category categoryEntity = categoryRepository.save(categoryConverter.toEntity(category));
    return categoryConverter.toDTO(categoryEntity);
  }

  @Override
  public List<CategoryDTO> findAll() {
    List<CategoryDTO> result =
        categoryRepository.findAll().stream()
            .map(data -> categoryConverter.toDTO(data))
            .collect(Collectors.toList());
    return result;
  }

  @Override
  public Category findByCode(String code) {
    return categoryRepository.findByCode(code);
  }
}
