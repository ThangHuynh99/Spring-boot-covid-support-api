package com.spring.covidsupport.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class UserEntity extends Base {
  @Column
  private String familyName;
  @Column
  private String userName;
  @Column
  private String passWord;
  @Column
  private String address;
  @Column
  private String wardName;
  @Column
  private Long groupNumber;
  @Column
  private String phone;
  @Column
  private String name;
  @Column
  private String age;
  @Column
  private String gender;
  @Column
  private String email;
  @Column
  private Date birthDay;

  @JsonManagedReference
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "user_role",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private List<Role> roles = new ArrayList<>();

  @JsonManagedReference
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Civilian> civilians;

  @JsonManagedReference
  @OneToMany(mappedBy = "userCart", cascade = CascadeType.ALL)
  private List<Cart> cartList;
}
