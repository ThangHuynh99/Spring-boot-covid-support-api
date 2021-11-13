package com.spring.travelbook.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.travelbook.constant.RoleName;
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
