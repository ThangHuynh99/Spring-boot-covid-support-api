package com.spring.travelbook.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Base {
  private String name;
  private String code;
  private Long quantity;
  private String status;
  private String price;
  private String product_image;
  private String description;

  @JsonBackReference
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "catagory_id")
  private Catagory category;

  @JsonBackReference
  @ManyToMany(mappedBy = "productList", fetch = FetchType.LAZY)
  private List<Cart> cartList;
}
