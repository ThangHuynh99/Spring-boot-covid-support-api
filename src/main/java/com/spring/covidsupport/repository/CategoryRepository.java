package com.spring.covidsupport.repository;

import com.spring.covidsupport.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCode(String code);
}
