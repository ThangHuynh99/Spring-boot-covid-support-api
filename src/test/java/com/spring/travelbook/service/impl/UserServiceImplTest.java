package com.spring.travelbook.service.impl;

import com.spring.travelbook.entity.UserEntity;
import com.spring.travelbook.repository.UserRepository;
import com.spring.travelbook.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    private UserService userService;

    private List<UserEntity> users;

    @Test
    void findByUserName() {
        Assert.assertEquals("admin",  userService.findByUserName("admin").getUserName());
    }

}