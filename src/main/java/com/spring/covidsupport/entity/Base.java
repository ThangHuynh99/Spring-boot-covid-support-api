package com.spring.covidsupport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
 @EntityListeners(AuditingEntityListener.class)
public class Base {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreatedDate
  @Column
  private Date createdDate;

  @LastModifiedDate
  @Column
  private Date modifiedDate;

  @CreatedBy
  @Column
  private String createdBy;

  @LastModifiedBy
  @Column
  private String modifiedBy;
}
