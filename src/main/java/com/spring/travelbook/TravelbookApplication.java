package com.spring.travelbook;

import com.spring.travelbook.entity.RoleEntity;
import com.spring.travelbook.entity.RoleName;
import com.spring.travelbook.entity.UserEntity;
import com.spring.travelbook.service.RoleService;
import com.spring.travelbook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.relation.Role;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@RequiredArgsConstructor
public class TravelbookApplication implements CommandLineRunner {
    private final UserService userService;
    private final RoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(TravelbookApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        UserEntity userEntity = new UserEntity("Huynh Ba Thang", "admin", "123456", "22", "male", "32 hoang the thien", "0905548920", "thang.huynh304@gmail.com", new SimpleDateFormat("dd/MM/yyyy").parse("30/04/1999"), new ArrayList<>());
//        UserEntity userEntity1 = new UserEntity("Pham Thi Minh Thuy", "manager", "123456", "25", "female", "54/3 ong ich khiem", "0935217297", "vetsieuquay@gmail.com", new SimpleDateFormat("dd/MM/yyyy").parse("17/02/1996"), new ArrayList<>());
//        userService.save(userEntity);
//        userService.save(userEntity1);
//
//        RoleEntity roleEntity = new RoleEntity(RoleName.ROLE_ADMIN, new ArrayList<>());
//        RoleEntity roleEntity1 = new RoleEntity(RoleName.ROLE_USER, new ArrayList<>());
//        RoleEntity roleEntity2 = new RoleEntity(RoleName.OWNER, new ArrayList<>());
//        RoleEntity roleEntity3 = new RoleEntity(RoleName.ROLE_MANAGER, new ArrayList<>());
//        roleService.save(roleEntity);
//        roleService.save(roleEntity1);
//        roleService.save(roleEntity2);
//        roleService.save(roleEntity3);
//
//        userService.saveRoleToUser("admin", RoleName.ROLE_ADMIN);
//        userService.saveRoleToUser("admin", RoleName.ROLE_USER);
//        userService.saveRoleToUser("admin", RoleName.ROLE_MANAGER);
//        userService.saveRoleToUser("manager", RoleName.ROLE_USER);
//        userService.saveRoleToUser("manager", RoleName.ROLE_MANAGER);
    }
}
