package com.spring.travelbook.service;

import com.spring.travelbook.entity.UserEntity;
import com.spring.travelbook.entity.RoleName;

import java.util.List;

public interface UserService {
    UserEntity findByUserName(String userName);
    void saveRoleToUser(String userName, RoleName roleName);
    UserEntity save(UserEntity userEntity);
    List<UserEntity> findAll();
    UserEntity findByName(String name);
    UserEntity findByEmail(String email);
}
