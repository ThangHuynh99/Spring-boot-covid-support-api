package com.spring.travelbook.service.impl;

import com.spring.travelbook.converter.UserConverter;
import com.spring.travelbook.dto.UserDTO;
import com.spring.travelbook.exception.UserNotFoundException;
import com.spring.travelbook.repository.UserRepository;
import com.spring.travelbook.entity.RoleEntity;
import com.spring.travelbook.entity.RoleName;
import com.spring.travelbook.entity.UserEntity;
import com.spring.travelbook.service.RoleService;
import com.spring.travelbook.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.metadata.DataSourcePoolMetadata;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @Autowired
    private final UserConverter userConverter;

    @Override
    public UserDTO findByUserName(String userName) {
        log.info("Select user from database by userName {}", userName);
        return userConverter.toDTO(userRepository.findByUserName(userName));
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
    public UserDTO save(UserDTO userDTO) {
        log.info("Insert new user to database");
        userDTO.setPassWord(passwordEncoder.encode(userDTO.getPassWord()));
        return userConverter.toDTO(userRepository.save(userConverter.toEntity(userDTO)));
    }

    @Override
    public List<UserDTO> findAll() {
//        return userRepository.findAll();
        log.info("Select all users from database");
        List<UserEntity> userEntities = em.createQuery("select u from UserEntity u", UserEntity.class).getResultList();
        return userEntities.stream().map(data -> userConverter.toDTO(data)).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByName(String name) {
        log.info("Select user from database by name {}", name);
        return userConverter.toDTO(userRepository.findByName(name));
    }

    @Override
    public UserDTO findByEmail(String email) {
        log.info("Select user from database by email {}", email);
        String sql = "select u from UserEntity u where u.email = ?1";
        TypedQuery<UserEntity> query = em.createQuery(sql, UserEntity.class).setParameter(1, email);
        return userConverter.toDTO(query.getSingleResult());
    }
}
