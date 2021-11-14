package com.spring.covidsupport.controller;

import com.spring.covidsupport.dto.ProductDTO;
import com.spring.covidsupport.entity.Product;
import com.spring.covidsupport.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
    value = "/api/v1/manager/product",
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class ProductController {
  @Autowired private ProductService productService;

  @ApiOperation(value = "Save new product", response = ProductDTO.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PostMapping("")
  public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO product) {
    return ResponseEntity.ok(productService.save(product));
  }

  @ApiOperation(value = "Update product", response = ProductDTO.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PutMapping("")
  public ResponseEntity<?> update(@RequestBody ProductDTO product) {
    return productService.update(product);
  }

  @ApiOperation(value = "find all products", response = Product.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("")
  public ResponseEntity<List<Product>> findAll() {
    return ResponseEntity.ok(productService.findAll());
  }

  @ApiOperation(value = "Delete product")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") Long id) {
    productService.delete(id);
    return ResponseEntity.ok().build();
  }

  @ApiOperation(value = "find product by name", response = Product.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/{name}")
  public ResponseEntity<Product> findByName(@PathVariable("name") String name) {
    return ResponseEntity.ok(productService.findByName(name));
  }

  @ApiOperation(value = "Disable product status", response = Product.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PutMapping("/status/disable/{id}")
  public ResponseEntity<?> disableProduct(@PathVariable("id") Long id) {
    return productService.disableStatus(id);
  }

  @ApiOperation(value = "Enable product status", response = Product.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PutMapping("/status/enable/{id}")
  public ResponseEntity<?> enableProduct(@PathVariable("id") Long id) {
    return productService.enableStatus(id);
  }

  @ApiOperation(value = "find products by groupNumber", response = Product.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/group/{wardName}")
  public ResponseEntity<List<Product>> findByGroupNumber(@PathVariable("wardName") String wardName) {
    return ResponseEntity.ok(productService.findByGroupNumber(wardName));
  }

  @ApiOperation(value = "find products by groupNumber and status = true", response = Product.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/group/{status}/{wardName}")
  public ResponseEntity<List<Product>> findByGroupNumberAndStatus(
      @PathVariable("wardName") String wardName, @PathVariable("status") boolean status) {
    return ResponseEntity.ok(productService.findByGroupNumberAndStatus(wardName, status));
  }
}
