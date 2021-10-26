package com.spring.travelbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Base{
    private String name;
    private String code;
    private Long quantity;
    private String status;
    private String price;
    private String product_image;
    private String description;
}
