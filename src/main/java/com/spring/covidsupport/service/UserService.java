package com.spring.covidsupport.service;

import com.spring.covidsupport.constant.RoleName;
import com.spring.covidsupport.dto.UserDTO;
import com.spring.covidsupport.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    UserEntity findByUserName(String userName);
    void saveRoleToUser(String userName, RoleName roleName);
    UserEntity save(UserEntity user);
    List<UserEntity> findAll(Pageable page);
    UserEntity findByName(String name);
    UserEntity findByEmail(String email);
    ResponseEntity<?> update(UserDTO userDTO);
}
