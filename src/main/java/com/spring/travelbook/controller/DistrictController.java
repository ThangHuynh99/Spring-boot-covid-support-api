package com.spring.travelbook.controller;

import com.spring.travelbook.dto.DistrictDTO;
import com.spring.travelbook.entity.City;
import com.spring.travelbook.entity.District;
import com.spring.travelbook.repository.DistrictRepository;
import com.spring.travelbook.service.DistrictService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @ApiOperation(value = "View district ", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorization"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Bad request")
    })
    @GetMapping("/")
    public ResponseEntity<List<DistrictDTO>> getAll() {
        return ResponseEntity.ok().body(districtService.findAll());
    }
}
