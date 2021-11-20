package com.spring.covidsupport.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class MyUser extends User {
  private Long id;
  private String wardName;
  private String district;
  private Long groupNumber;
  private List<RoleDTO> roles;

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

  public List<RoleDTO> getRoles() {
    return roles;
  }

  public void setRoles(List<RoleDTO> roles) {
    this.roles = roles;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }
}
