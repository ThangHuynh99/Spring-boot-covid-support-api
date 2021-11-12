package com.spring.travelbook.dto;

import com.spring.travelbook.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class MyUser extends User {
  private Long id;
  private String wardName;
  private Long groupNumber;
  private List<Role> roles;

  public MyUser(
      String username, String password, Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setWardName(String wardName) {
    this.wardName = wardName;
  }

  public void setGroupNumber(Long groupNumber) {
    this.groupNumber = groupNumber;
  }

  public Long getId() {
    return id;
  }

  public String getWardName() {
    return wardName;
  }

  public Long getGroupNumber() {
    return groupNumber;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }
}
