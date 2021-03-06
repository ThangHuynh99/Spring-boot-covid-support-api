package com.spring.covidsupport.service.impl;

import com.spring.covidsupport.entity.UserEntity;
import com.spring.covidsupport.repository.RoleRepository;
import com.spring.covidsupport.service.RoleService;
import com.spring.covidsupport.entity.Role;
import com.spring.covidsupport.constant.RoleName;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByRoleName(RoleName roleName) {
        log.info("Get role by roleName {}", roleName.toString());
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public List<Role> findAll() {
        log.info("Get list roles from database");
        return roleRepository.findAll();
    }


}
