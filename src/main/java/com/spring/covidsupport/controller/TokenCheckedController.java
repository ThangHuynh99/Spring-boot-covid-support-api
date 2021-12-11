package com.spring.covidsupport.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1/")
public class TokenCheckedController {

    /**
     * this api use to check if the token is expired or not
     * @return
     */
    @ApiOperation(value = "check valid token")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success"),
                    @ApiResponse(code = 401, message = "Unauthorization"),
                    @ApiResponse(code = 403, message = "Access denied"),
                    @ApiResponse(code = 404, message = "Bad request")
            })
    @PostMapping("checkToken")
    public ResponseEntity<?> checkToken() {
        return ResponseEntity.ok().build();
    }
}
