package com.spring.travelbook.service;

import com.spring.travelbook.entity.Civilian;
import com.spring.travelbook.entity.RoleName;
import com.spring.travelbook.entity.User;

import java.util.List;

public interface UserService {
    User findByUserName(String userName);
    void saveRoleToUser(String userName, RoleName roleName);
    User save(User user);
    List<User> findAll();
    User findByName(String name);
    User findByEmail(String email);
}
