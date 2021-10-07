package com.spring.travelbook.controller;

import com.spring.travelbook.entity.RoleEntity;
import com.spring.travelbook.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    @Autowired
    private static RoleService roleService;

    @ApiOperation(value = "Get list role", response = RoleEntity.class)
    @GetMapping("/")
    public ResponseEntity<List<RoleEntity>> findAll() {
        return ResponseEntity.ok().body(roleService.findAll());
    }
}
