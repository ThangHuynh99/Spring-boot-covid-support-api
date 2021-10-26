package com.spring.travelbook.service;

import com.spring.travelbook.dto.UserDTO;
import com.spring.travelbook.entity.UserEntity;
import com.spring.travelbook.entity.RoleName;

import java.util.List;

public interface UserService {
    UserDTO findByUserName(String userName);
    void saveRoleToUser(String userName, RoleName roleName);
    UserDTO save(UserDTO userDTO);
    List<UserDTO> findAll();
    UserDTO findByName(String name);
    UserDTO findByEmail(String email);
}
