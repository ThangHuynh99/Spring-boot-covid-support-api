package com.spring.covidsupport.service.impl;

import com.spring.covidsupport.dto.MyUser;
import com.spring.covidsupport.dto.RoleDTO;
import com.spring.covidsupport.entity.Role;
import com.spring.covidsupport.entity.UserEntity;
import com.spring.covidsupport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
  @Autowired private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity userEntity =
        userRepository
            .findByUserName(username)
            .orElseThrow(
                () -> new UsernameNotFoundException("User not found with username " + username));

    // put thong tin vao trong security de duy tri thong tin khi user login vao he thong
    List<GrantedAuthority> authorities = new ArrayList<>();
    // tim duoc role thong qua @manytomany
    for (Role role : userEntity.getRoles()) {
      authorities.add(new SimpleGrantedAuthority(role.getRoleName().name()));
    }
    MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassWord(), authorities);
    myUser.setId(userEntity.getId());
    myUser.setGroupNumber(userEntity.getGroupNumber());
    myUser.setWardName(userEntity.getWardName());
    return myUser;
  }

  public MyUser loadResponse(String username) {
    UserEntity userEntity =
        userRepository
            .findByUserName(username)
            .orElseThrow(
                () -> new UsernameNotFoundException("User not found with username " + username));
    MyUser myUser =
        new MyUser(userEntity.getUserName(), userEntity.getPassWord(), new ArrayList<>());
    myUser.setId(userEntity.getId());
    myUser.setGroupNumber(userEntity.getGroupNumber());
    myUser.setWardName(userEntity.getWardName());
    myUser.setRoles(toRoleDTO(userEntity.getRoles()));
    myUser.setDistrict(userEntity.getDistrict());
    return myUser;
  }

  private List<RoleDTO> toRoleDTO(List<Role> roles) {
    List<RoleDTO> roleDTOS = new ArrayList<>();
      for (Role role: roles) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setRoleName(role.getRoleName());
        roleDTOS.add(roleDTO);
      }
    return roleDTOS;
  }
}
