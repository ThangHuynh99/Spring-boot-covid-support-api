package com.spring.covidsupport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.covidsupport.constant.VaccineStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vaccine")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  @Enumerated(EnumType.STRING)
  private VaccineStatus vaccineStatus;

  @Column private Date date;

  @Column private String vaccineName;

  @JsonBackReference
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "civilian_id")
  private Civilian civilian;
}
