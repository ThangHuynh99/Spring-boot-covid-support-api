package com.spring.travelbook.service.impl;

import com.spring.travelbook.exception.UserNotFoundException;
import com.spring.travelbook.repository.UserRepository;
import com.spring.travelbook.entity.RoleEntity;
import com.spring.travelbook.entity.RoleName;
import com.spring.travelbook.entity.UserEntity;
import com.spring.travelbook.service.RoleService;
import com.spring.travelbook.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    @PersistenceContext
    private EntityManager em;

    @Override
    public UserEntity findByUserName(String userName) {
        log.info("Select user from database by userName {}", userName);
        return userRepository.findByUserName(userName);
    }

    @Override
    public void saveRoleToUser(String userName, RoleName roleName) {
        log.info("Insert role for user to database roleName {}", roleName.toString());
        RoleEntity roleEntity = roleService.findByRoleName(roleName);
        UserEntity userEntity = userRepository.findByUserName(userName);
        userEntity.getRoles().add(roleEntity);
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        log.info("Insert new user to database");
        userEntity.setPassWord(passwordEncoder.encode(userEntity.getPassWord()));
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> findAll() {
//        return userRepository.findAll();
        log.info("Select all users from database");
        return em.createQuery("select u from UserEntity u", UserEntity.class).getResultList();
    }

    @Override
    public UserEntity findByName(String name) {
        log.info("Select user from database by name {}", name);
        return userRepository.findByName(name);
    }

    @Override
    public UserEntity findByEmail(String email) {
        log.info("Select user from database by email {}", email);
        String sql = "select u from UserEntity u where u.email = ?1";
        TypedQuery<UserEntity> query = em.createQuery(sql, UserEntity.class).setParameter(1, email);
        return query.getSingleResult();
    }
}
