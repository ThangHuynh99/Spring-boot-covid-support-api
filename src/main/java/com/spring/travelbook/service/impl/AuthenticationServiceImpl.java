package com.spring.travelbook.service.impl;

import com.spring.travelbook.dto.LoginRequest;
import com.spring.travelbook.dto.MyUser;
import com.spring.travelbook.response.JwtResponse;
import com.spring.travelbook.response.MessageResponse;
import com.spring.travelbook.service.AuthenticationService;
import com.spring.travelbook.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
  @Autowired private AuthenticationManager authenticationManager;
  @Autowired private MyUserDetailsService userDetailsService;
  @Autowired private JwtUtils jwtUtil;

  @Override
  public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              loginRequest.getUserName(), loginRequest.getPassWord()));
    } catch (BadCredentialsException e) {
      return ResponseEntity.badRequest()
          .body(new MessageResponse("userName or passWord is incorrect!"));
    }

    final UserDetails userDetails =
        userDetailsService.loadUserByUsername(loginRequest.getUserName());
    final String jwt = jwtUtil.generateToken(userDetails);
    MyUser myUser = userDetailsService.loadResponse(loginRequest.getUserName());
    return ResponseEntity.ok(
        new JwtResponse(
            jwt,
            myUser.getId(),
            myUser.getUsername(),
            myUser.getWardName(),
            myUser.getGroupNumber(),
            myUser.getRoles()));
  }
}
