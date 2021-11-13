package com.spring.travelbook.dto;

import com.spring.travelbook.constant.RoleName;
import lombok.Data;

@Data
public class RoleDTO extends Abstract{
    private RoleName roleName;
}
