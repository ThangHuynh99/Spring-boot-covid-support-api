package com.spring.travelbook.service;

import com.spring.travelbook.dto.LoginRequest;
import com.spring.travelbook.response.JwtResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService{
    ResponseEntity<?> authenticateUser(LoginRequest loginRequest) throws Exception;
}
