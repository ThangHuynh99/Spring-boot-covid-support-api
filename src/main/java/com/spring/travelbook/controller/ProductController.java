package com.spring.travelbook.controller;

import com.spring.travelbook.entity.Product;
import com.spring.travelbook.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
  @Autowired private ProductService productService;

  @ApiOperation(value = "Save new product", response = Product.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PostMapping("")
  public ResponseEntity<Product> save(@RequestBody Product product) {
    return ResponseEntity.ok(productService.save(product));
  }

  @ApiOperation(value = "Update product", response = Product.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PutMapping("")
  public ResponseEntity<Product> update(@RequestBody Product product) {
    return ResponseEntity.ok(productService.update(product));
  }

  @ApiOperation(value = "find all products", response = Product.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping
  public ResponseEntity<List<Product>> findAll(@RequestBody Product product) {
    return ResponseEntity.ok(productService.findAll());
  }

  @ApiOperation(value = "Delete product", response = Product.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @DeleteMapping("")
  public ResponseEntity<List<Product>> delete() {
    return ResponseEntity.ok(productService.findAll());
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

  @ApiOperation(value = "update product status", response = Product.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PostMapping("/status/{id}/{status}")
  public ResponseEntity<Product> updateStatus(
      @PathVariable("id") Long id, @PathVariable("status") int status) {
      return ResponseEntity.ok(productService.updateStatus(id, status));
  }

  @ApiOperation(value = "find products by groupNumber", response = Product.class)
  @ApiResponses(
          value = {
                  @ApiResponse(code = 200, message = "Success"),
                  @ApiResponse(code = 401, message = "Unauthorization"),
                  @ApiResponse(code = 403, message = "Access denied"),
                  @ApiResponse(code = 404, message = "Bad request")
          })
  @PostMapping("/group/{groupNumber}")
  public ResponseEntity<List<Product>> updateStatus(
          @PathVariable("groupNumber") int groupNumber) {
    return ResponseEntity.ok(productService.findByGroupNumber(groupNumber));
  }
}
