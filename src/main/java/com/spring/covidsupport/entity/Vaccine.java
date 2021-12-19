package com.spring.covidsupport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

  @Column private String date;
  @Column private String vaccineName;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "civilian_id")
  private Civilian civilian;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity userE;
}
