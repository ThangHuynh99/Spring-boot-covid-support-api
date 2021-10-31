package com.spring.travelbook.controller;

import com.spring.travelbook.dto.UserDTO;
import com.spring.travelbook.entity.RoleEntity;
import com.spring.travelbook.service.RoleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
  @Autowired private static RoleService roleService;

  @ApiOperation(value = "View list role", response = UserDTO.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/")
  public ResponseEntity<List<RoleEntity>> findAll() {
    return ResponseEntity.ok().body(roleService.findAll());
  }
}
