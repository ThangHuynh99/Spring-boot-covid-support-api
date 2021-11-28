package com.spring.covidsupport.repository;

import com.spring.covidsupport.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
    List<Product> findByGroupNumber(int group);
    List<Product> findByGroupNumberAndStatus(int group, boolean status);
    List<Product> findByStatusAndDistrictAndWard(boolean status, String district, String ward);
}
