package com.spring.travelbook.repository;

import com.spring.travelbook.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
    List<Product> findByGroupNumber(int group);
}
