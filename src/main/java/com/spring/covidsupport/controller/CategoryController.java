package com.spring.covidsupport.controller;

import com.spring.covidsupport.dto.CategoryDTO;
import com.spring.covidsupport.entity.Category;
import com.spring.covidsupport.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manager/category")
public class CategoryController {
  @Autowired private CategoryService categoryService;

  @ApiOperation(value = "Save new product category", response = CategoryDTO.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PostMapping("")
  public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO category) {
    return ResponseEntity.ok(categoryService.save(category));
  }

  @ApiOperation(value = "find product categories", response = CategoryDTO.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("")
  public ResponseEntity<List<CategoryDTO>> findAll() {
    return ResponseEntity.ok(categoryService.findAll());
  }

  @ApiOperation(value = "find product categories by code", response = Category.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/{code}")
  public ResponseEntity<Category> findByCode(@PathVariable("code") String code) {
    return ResponseEntity.ok(categoryService.findByCode(code));
  }
}
