package com.spring.travelbook.entity;

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
public class News extends Base{
    private String title;
    private String thumbnail;
    private String shortDescription;
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
}
