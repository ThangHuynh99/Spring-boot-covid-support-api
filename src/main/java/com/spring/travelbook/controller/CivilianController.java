package com.spring.travelbook.controller;

import com.spring.travelbook.entity.Civilian;
import com.spring.travelbook.service.CivilianService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/civilians")
public class CivilianController {
  @Autowired
  private CivilianService civilianService;

  @ApiOperation(value = "Find all faminy member by User", response = Civilian.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/{id}")
  public ResponseEntity<List<Civilian>> findAllFamilyMemberByUser(@RequestBody Long id) {
    return ResponseEntity.ok(civilianService.findAllFamilyMemberByUser(id));
  }

  @ApiOperation(value = "Find all faminy member by User", response = Civilian.class)
  @ApiResponses(
          value = {
                  @ApiResponse(code = 200, message = "Success"),
                  @ApiResponse(code = 401, message = "Unauthorization"),
                  @ApiResponse(code = 403, message = "Access denied"),
                  @ApiResponse(code = 404, message = "Bad request")
          })
  @GetMapping("")
  public ResponseEntity<List<Civilian>> findAllCivilian() {
    return ResponseEntity.ok(civilianService.findAll());
  }
}
