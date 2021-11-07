package com.spring.travelbook.repository;

import com.spring.travelbook.entity.Role;
import com.spring.travelbook.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(RoleName roleName);
}
