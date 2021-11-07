package com.spring.travelbook.service.impl;

import com.spring.travelbook.constant.ProductConstant;
import com.spring.travelbook.entity.Product;
import com.spring.travelbook.repository.ProductRepository;
import com.spring.travelbook.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired private ProductRepository productRepository;

  @Override
  public Product save(Product product) {
    product.setStatus(ProductConstant.AVAILABLE);
    return productRepository.save(product);
  }

  @Override
  public Product update(Product product) {
    return productRepository.save(product);
  }

  @Override
  public void delete(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  @Override
  public Product findByName(String name) {
    return productRepository.findByName(name);
  }

  @Override
  public Product updateStatus(Long id, int status) {
    Optional<Product> product = productRepository.findById(id);

    if (!product.isPresent()) {
      return new Product();
    }

    if (status == 1) {
      product.get().setStatus(ProductConstant.AVAILABLE);
    } else if (status == 0) {
      product.get().setStatus(ProductConstant.NOT_AVAILABLE);
    }

    return productRepository.save(product.get());
  }

    @Override
    public List<Product> findByGroupNumber(int groupNumber) {
        return productRepository.findByGroupNumber(groupNumber);
    }
}
