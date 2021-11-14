package com.spring.covidsupport.controller;

import com.spring.covidsupport.dto.DistrictDTO;
import com.spring.covidsupport.service.DistrictService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/district")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorization"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Bad request")
    })
    @GetMapping("")
    public ResponseEntity<List<DistrictDTO>> getAll() {
        return ResponseEntity.ok().body(districtService.findAll());
    }
}
