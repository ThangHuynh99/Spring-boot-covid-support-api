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
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catagory extends Base {
  private String name;
  private String code;

  @JsonManagedReference
  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private List<Product> productList;
}
