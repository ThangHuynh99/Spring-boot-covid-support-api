package com.spring.travelbook.service;

import com.spring.travelbook.constant.RoleName;
import com.spring.travelbook.entity.UserEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserEntity findByUserName(String userName);
    void saveRoleToUser(String userName, RoleName roleName);
    UserEntity save(UserEntity user);
    List<UserEntity> findAll(Pageable page);
    UserEntity findByName(String name);
    UserEntity findByEmail(String email);
}
