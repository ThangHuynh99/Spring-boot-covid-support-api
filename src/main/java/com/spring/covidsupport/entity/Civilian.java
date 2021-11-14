package com.spring.covidsupport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.covidsupport.constant.VaccineStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "civilian")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Civilian extends Base {
  @Column private String name;
  @Column private String age;
  @Column private String gender;
  @Column private String phone;
  @Column private String email;
  @Column private Date birthDay;

  @Column
  @Enumerated(EnumType.STRING)
  private VaccineStatus vaccineStatus;

  @JsonBackReference
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @JsonManagedReference
  @OneToMany(mappedBy = "civilian", cascade = CascadeType.ALL)
  private List<Vaccine> vaccineList;
}
