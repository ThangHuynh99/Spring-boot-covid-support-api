package com.spring.travelbook.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ward")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ward extends Base {
  @Column
  private String name;

  @JsonBackReference
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "district_id")
  private District district;
}
