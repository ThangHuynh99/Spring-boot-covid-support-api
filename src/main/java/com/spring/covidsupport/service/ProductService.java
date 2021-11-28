package com.spring.covidsupport.service;

import com.spring.covidsupport.dto.ProductDTO;
import com.spring.covidsupport.entity.Product;
import com.sun.xml.bind.v2.runtime.reflect.ListTransducedAccessorImpl;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
  ProductDTO save(ProductDTO product);

  ResponseEntity<?> update(ProductDTO product);

  void delete(Long id);

  List<Product> findAll();

  Product findByName(String name);

  ResponseEntity<?> enableStatus(Long id);

  ResponseEntity<?> disableStatus(Long id);

  List<Product> findByGroupNumber(String wardName);

  List<Product> findByGroupNumberAndStatus(String wardName, boolean status);

  List<Product> findByStatusAndDistrictAndWard(String district, String ward);
}
