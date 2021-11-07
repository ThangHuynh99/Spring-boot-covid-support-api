package com.spring.travelbook.service;

import com.spring.travelbook.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product update(Product product);
    void delete(Long id);
    List<Product> findAll();
    Product findByName(String name);
    Product updateStatus(Long id, int status);
    List<Product> findByGroupNumber(int groupNumber);
}
