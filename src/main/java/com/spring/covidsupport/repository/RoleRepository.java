package com.spring.covidsupport.repository;

import com.spring.covidsupport.entity.Role;
import com.spring.covidsupport.constant.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(RoleName roleName);
}
