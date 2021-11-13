package com.spring.travelbook.service;

import com.spring.travelbook.entity.Role;
import com.spring.travelbook.constant.RoleName;

import java.util.List;

public interface RoleService {
    Role findByRoleName(RoleName roleName);
    List<Role> findAll();
}
