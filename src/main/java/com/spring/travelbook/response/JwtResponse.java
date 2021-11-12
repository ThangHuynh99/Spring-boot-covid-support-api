package com.spring.travelbook.response;

import com.spring.travelbook.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private Long id;
    private String userName;
    private String wardName;
    private Long groupNumber;
    private List<Role> roles;
}
