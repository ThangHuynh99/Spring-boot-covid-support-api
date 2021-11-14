package com.spring.covidsupport.service;

import com.spring.covidsupport.dto.CategoryDTO;
import com.spring.covidsupport.entity.Category;

import java.util.List;

public interface CategoryService {
  CategoryDTO save(CategoryDTO category);

  List<CategoryDTO> findAll();

  Category findByCode(String code);
}
