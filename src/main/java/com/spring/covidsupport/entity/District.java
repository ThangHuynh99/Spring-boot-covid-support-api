package com.spring.covidsupport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "district")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class District extends Base {
  private String name;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "city_id")
  private City city;

  @JsonManagedReference
  @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
  private List<Ward> wards;
}
