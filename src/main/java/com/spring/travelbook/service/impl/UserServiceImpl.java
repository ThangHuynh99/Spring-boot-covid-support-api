package com.spring.travelbook.service.impl;

import com.spring.travelbook.entity.Civilian;
import com.spring.travelbook.repository.CivilianRepository;
import com.spring.travelbook.repository.UserRepository;
import com.spring.travelbook.entity.Role;
import com.spring.travelbook.entity.RoleName;
import com.spring.travelbook.entity.User;
import com.spring.travelbook.service.RoleService;
import com.spring.travelbook.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private CivilianRepository civilianRepository;

    @PersistenceContext
    private EntityManager em;

    @Override
    public User findByUserName(String userName) {
        log.info("Select user from database by userName {}", userName);
        return userRepository.findByUserName(userName);
    }

    @Override
    public void saveRoleToUser(String userName, RoleName roleName) {
        log.info("Insert role for user to database roleName {}", roleName.toString());
        Role roleEntity = roleService.findByRoleName(roleName);
        User userEntity = userRepository.findByUserName(userName);
        userEntity.getRoles().add(roleEntity);
        userRepository.save(userEntity);
    }

    @Override
    public User save(User user) {
        log.info("Insert new user to database");
        user.setPassWord(passwordEncoder.encode(user.getPassWord()));
        List<Role> role = Arrays.asList(roleService.findByRoleName(RoleName.ROLE_USER));
        user.setRoles(role);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll(Pageable page) {
        log.info("Select all users from database");
        //List<User> userEntities = em.createQuery("select u from User u", User.class).getResultList();
        return userRepository.findAll(page).getContent();
    }

    @Override
    public User findByName(String name) {
        log.info("Select user from database by name {}", name);
        return userRepository.findByName(name);
    }

    @Override
    public User findByEmail(String email) {
        log.info("Select user from database by email {}", email);
        String sql = "select u from User u where u.email = ?1";
        TypedQuery<User> query = em.createQuery(sql, User.class).setParameter(1, email);
        return query.getSingleResult();
    }
}
