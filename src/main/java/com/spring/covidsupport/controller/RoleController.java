package com.spring.covidsupport.controller;

import com.spring.covidsupport.entity.Role;
import com.spring.covidsupport.entity.UserEntity;
import com.spring.covidsupport.service.RoleService;
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
@RequestMapping(value = "/api/v1/roles")
public class RoleController {
  @Autowired private RoleService roleService;

  @ApiOperation(value = "View list role", response = Role.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping()
  public ResponseEntity<List<Role>> findAll() {
    return ResponseEntity.ok().body(roleService.findAll());
  }
}
