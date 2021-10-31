package com.spring.travelbook.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "family_information")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyInformation extends Base {
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
  private int groupNumber;
  @Column
  private String token;
  @Column
  private String phone;

  @JsonManagedReference
  @OneToMany(mappedBy = "familyInformation", cascade = CascadeType.ALL)
  private List<Civilian> civilians;

  @JsonManagedReference
  @OneToMany(mappedBy = "familyInfo", cascade = CascadeType.ALL)
  private List<Cart> cartList;
}
