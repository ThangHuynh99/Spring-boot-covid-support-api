package com.spring.covidsupport.response;

import com.spring.covidsupport.dto.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private Long id;
    private String userName;
    private String wardName;
    private String district;
    private Long groupNumber;
    private List<RoleDTO> roles;

    public JwtResponse(String token, Long id, String userName, String wardName, String district, Long groupNumber, List<RoleDTO> roles) {
        this.token = token;
        this.id = id;
        this.userName = userName;
        this.wardName = wardName;
        this.district = district;
        this.groupNumber = groupNumber;
        this.roles = roles;
    }
}
