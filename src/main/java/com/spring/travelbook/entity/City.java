package com.spring.travelbook.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City extends Base {
  private String name;

  @JsonManagedReference
  @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
  private List<District> districts;
}
