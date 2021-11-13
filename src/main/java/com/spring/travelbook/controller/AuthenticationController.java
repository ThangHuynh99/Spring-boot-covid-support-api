package com.spring.travelbook.controller;

import com.spring.travelbook.dto.LoginRequest;
import com.spring.travelbook.dto.RegisterDTO;
import com.spring.travelbook.entity.UserEntity;
import com.spring.travelbook.service.AuthenticationService;
import com.spring.travelbook.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationService authService;

    @ApiOperation(value = "Authentication user")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success"),
                    @ApiResponse(code = 404, message = "Bad request")
            })
    @PostMapping(value = "/login", consumes={"application/json"})
    public ResponseEntity<?> login(@RequestBody LoginRequest login) throws Exception {
        return authService.authenticateUser(login);
    }

    @ApiOperation(value = "Register new user", response = UserEntity.class)
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success"),
                    @ApiResponse(code = 401, message = "Unauthorization"),
                    @ApiResponse(code = 403, message = "Access denied"),
                    @ApiResponse(code = 404, message = "Bad request")
            })
    @PostMapping(value = "/signup", consumes={"application/json"})
    public ResponseEntity<UserEntity> register(@RequestBody RegisterDTO RegisterDTO) {
        UserEntity user = toRegister(RegisterDTO);
        return ResponseEntity.ok().body(userService.save(user));
    }

    private UserEntity toRegister(RegisterDTO request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(request.getUserName());
        userEntity.setPassWord(request.getPassWord());
        userEntity.setGroupNumber(request.getGroupNumber());
        userEntity.setWardName(request.getWardName());
        return userEntity;
    }
}
