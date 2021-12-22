package com.spring.covidsupport.service.impl;

import com.spring.covidsupport.constant.ProductConstant;
import com.spring.covidsupport.converter.ProductConverter;
import com.spring.covidsupport.dto.ProductDTO;
import com.spring.covidsupport.entity.Category;
import com.spring.covidsupport.entity.Product;
import com.spring.covidsupport.entity.Ward;
import com.spring.covidsupport.repository.CategoryRepository;
import com.spring.covidsupport.repository.ProductRepository;
import com.spring.covidsupport.repository.WardRepository;
import com.spring.covidsupport.response.MessageResponse;
import com.spring.covidsupport.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
  @Autowired private ProductRepository productRepository;
  @Autowired private CategoryRepository catagoryRepository;
  @Autowired private ProductConverter productConverter;
  @Autowired private WardRepository wardRepository;

  @Override
  public ProductDTO save(ProductDTO productDTO) {
    Product product = productConverter.toEntity(productDTO);
    product.setCategory(checkCatagory(productDTO.getCatalogType()));
    product.setStatus(ProductConstant.AVAILABLE);
//    product.setGroupNumber(findByWardName(productDTO.getWardName()).intValue());
    return productConverter.toDTO(productRepository.save(product));
  }

  @Override
  public ResponseEntity<?> update(ProductDTO product) {
    Product productEntity = productRepository.getById(product.getId());
    if(productEntity == null) {
      return ResponseEntity.badRequest().body(new MessageResponse("Product does not exist!"));
    }
    Product result = productRepository.save(productConverter.toEntity(product, productEntity));
    return ResponseEntity.ok(productConverter.toDTO(result));
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
  public ResponseEntity<?> enableStatus(Long id) {
    Optional<Product> product = productRepository.findById(id);

    if (!product.isPresent()) {
      return ResponseEntity.badRequest().body(new MessageResponse("Product does not exist"));
    }

    product.get().setStatus(ProductConstant.AVAILABLE);

    return ResponseEntity.ok(productRepository.save(product.get()));
  }

  @Override
  public ResponseEntity<?> disableStatus(Long id) {
    Optional<Product> product = productRepository.findById(id);

    if (!product.isPresent()) {
      return ResponseEntity.badRequest().body(new MessageResponse("Product does not exist"));
    }

    product.get().setStatus(ProductConstant.NOT_AVAILABLE);
    return ResponseEntity.ok(productRepository.save(product.get()));
  }

  @Override
  public List<Product> findByGroupNumber(String wardName) {
    int groupNumber = findByWardName(wardName).intValue();
    return productRepository.findByGroupNumber(groupNumber);
  }

  @Override
  public List<Product> findByGroupNumberAndStatus(String wardName, boolean status) {
    int groupNum = findByWardName(wardName).intValue();
    return productRepository.findByGroupNumberAndStatus(groupNum, status);
  }

  @Override
  public List<Product> findByStatusAndDistrictAndWard(String district, String ward) {
    return productRepository.findByStatusAndDistrictAndWard(ProductConstant.AVAILABLE, district, ward);
  }

  @Override
  public List<Product> findByDisableStatusAndDistrictAndWard(String district, String ward) {
    return productRepository.findByStatusAndDistrictAndWard(ProductConstant.NOT_AVAILABLE, district, ward);
  }

  private Category checkCatagory(String catagoryCode) {
    if (StringUtils.isBlank(catagoryCode)) {
      return null;
    }
    return catagoryRepository.findByCode(catagoryCode);
  }

  private Long findByWardName(String name) {
    Ward ward = wardRepository.findByName(name);
    return ward.getId();
  }
}
