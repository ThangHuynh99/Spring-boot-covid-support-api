package com.spring.covidsupport.service.impl;

import com.spring.covidsupport.constant.RoleName;
import com.spring.covidsupport.entity.Role;
import com.spring.covidsupport.entity.UserEntity;
import com.spring.covidsupport.repository.CivilianRepository;
import com.spring.covidsupport.repository.UserRepository;
import com.spring.covidsupport.service.RoleService;
import com.spring.covidsupport.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final RoleService roleService;
  private final PasswordEncoder passwordEncoder;

  @Autowired private CivilianRepository civilianRepository;

  @PersistenceContext private EntityManager em;

  @Override
  public UserEntity findByUserName(String userName) {
    log.info("Select user from database by userName {}", userName);
    return userRepository
        .findByUserName(userName)
        .orElseThrow(
            () -> new UsernameNotFoundException("User not found with username " + userName));
  }

  @Override
  public void saveRoleToUser(String userName, RoleName roleName) {
    log.info("Insert role for user to database roleName {}", roleName.toString());
    Role roleEntity = roleService.findByRoleName(roleName);
    UserEntity userEntity =
        userRepository
            .findByUserName(userName)
            .orElseThrow(
                () -> new UsernameNotFoundException("User not found with username " + userName));
    userEntity.getRoles().add(roleEntity);
    userRepository.save(userEntity);
  }

  @Override
  public UserEntity save(UserEntity user) {
    log.info("Insert new user to database");
    user.setPassWord(passwordEncoder.encode(user.getPassWord()));
    List<Role> role = Arrays.asList(roleService.findByRoleName(RoleName.ROLE_USER));
    user.setRoles(role);
    return userRepository.save(user);
  }

  @Override
  public List<UserEntity> findAll(Pageable page) {
    log.info("Select all users from database");
    // List<User> userEntities = em.createQuery("select u from User u", User.class).getResultList();
    return userRepository.findAll(page).getContent();
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
