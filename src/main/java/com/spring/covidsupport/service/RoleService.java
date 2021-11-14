package com.spring.covidsupport.service;

import com.spring.covidsupport.entity.Role;
import com.spring.covidsupport.constant.RoleName;

import java.util.List;

public interface RoleService {
    Role findByRoleName(RoleName roleName);
    List<Role> findAll();
}
