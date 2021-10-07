package com.spring.travelbook.service.impl;

import com.spring.travelbook.repository.RoleRepository;
import com.spring.travelbook.service.RoleService;
import com.spring.travelbook.entity.RoleEntity;
import com.spring.travelbook.entity.RoleName;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public RoleEntity findByRoleName(RoleName roleName) {
        log.info("Get role by roleName {}", roleName.toString());
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public List<RoleEntity> findAll() {
        log.info("Get list roles from database");
        return roleRepository.findAll();
    }

}
