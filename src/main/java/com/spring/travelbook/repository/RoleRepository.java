package com.spring.travelbook.repository;

import com.spring.travelbook.entity.RoleEntity;
import com.spring.travelbook.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByRoleName(RoleName roleName);
}
