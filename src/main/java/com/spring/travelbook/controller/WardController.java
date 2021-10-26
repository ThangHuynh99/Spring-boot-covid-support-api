package com.spring.travelbook.controller;

import com.spring.travelbook.dto.WardDTO;
import com.spring.travelbook.service.WardService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/ward")
public class WardController {
    @Autowired
    private WardService wardService;

    @ApiOperation(value = "View list Ward by District id ", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorization"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Bad request")
    })
    @GetMapping("/{district_id}")
    public ResponseEntity<List<WardDTO>> findByDictrictId(
            @ApiParam(name = "District Id",
                    type = "long",
                    value = "Id of District",
                    example = "1",
                    required = true)
            @PathVariable("district_id")
                    Long district_id) {
        return ResponseEntity.ok().body(wardService.findByDistrictId(district_id));
    }

    @ApiOperation(value = "View list Ward", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorization"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Bad request")
    })
    @GetMapping("/")
    public ResponseEntity<List<WardDTO>> getAll() {
        return ResponseEntity.ok().body(wardService.findAll());
    }
}
