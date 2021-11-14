package com.spring.covidsupport.service;

import com.spring.covidsupport.dto.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService{
    ResponseEntity<?> authenticateUser(LoginRequest loginRequest) throws Exception;
}
