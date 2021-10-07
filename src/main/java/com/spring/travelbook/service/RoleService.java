package com.spring.travelbook.service;

import com.spring.travelbook.entity.RoleEntity;
import com.spring.travelbook.entity.RoleName;

import java.util.List;

public interface RoleService {
    RoleEntity findByRoleName(RoleName roleName);
    List<RoleEntity> findAll();
}
