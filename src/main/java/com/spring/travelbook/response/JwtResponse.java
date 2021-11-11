package com.spring.travelbook.response;

import com.spring.travelbook.entity.Role;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String userName;
    private String email;
    private List<Role> roles;
}
