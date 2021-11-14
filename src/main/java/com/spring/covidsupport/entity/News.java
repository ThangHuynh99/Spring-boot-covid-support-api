package com.spring.covidsupport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "news")
public class News extends Base {
  @Column
  private String title;
  @Column
  private String thumbnail;
  @Column
  private String shortDescription;
  @Column(name = "content", columnDefinition = "TEXT")
  private String content;
}
