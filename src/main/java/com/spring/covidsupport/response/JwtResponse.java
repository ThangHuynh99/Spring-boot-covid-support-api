package com.spring.covidsupport.response;

import com.spring.covidsupport.dto.RoleDTO;
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
    private List<RoleDTO> roles;
}
