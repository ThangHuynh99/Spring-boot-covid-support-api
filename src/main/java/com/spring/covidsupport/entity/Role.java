package com.spring.covidsupport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.covidsupport.constant.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends Base {
  @Column
  @Enumerated(EnumType.STRING)
  private RoleName roleName;

  @JsonBackReference
  @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
  private List<UserEntity> users = new ArrayList<>();
}
