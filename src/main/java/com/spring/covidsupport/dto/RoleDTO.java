package com.spring.covidsupport.dto;

import com.spring.covidsupport.constant.RoleName;
import lombok.Data;

@Data
public class RoleDTO extends Abstract{
    private RoleName roleName;
}
