package com.spring.covidsupport.controller;

import com.spring.covidsupport.entity.Product;
import com.spring.covidsupport.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
    value = "/api/v1/product",
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class ProductUserController {
  @Autowired private ProductService productService;

  @ApiOperation(value = "find products by groupNumber", response = Product.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/{district}/{wardName}")
  public ResponseEntity<List<Product>> findByStatusAndDistrictAndWard(
      @PathVariable("district") String dictrict,
      @PathVariable("wardName") String wardName) {
    return ResponseEntity.ok(productService.findByStatusAndDistrictAndWard(dictrict, wardName));
  }
}
