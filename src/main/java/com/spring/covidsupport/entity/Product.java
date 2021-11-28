package com.spring.covidsupport.entity;

import com.fasterxml.jackson.annotation.*;
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
@JsonIgnoreProperties("cartList")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product extends Base {
  @Column
  private String name;
  @Column
  private String code;
  @Column
  private Long quantity;
  @Column
  private boolean status;
  @Column
  private String price;
  @Column
  private String product_image;
  @Column
  private String description;
  @Column
  private String district;
  @Column
  private String ward;
  @Column
  private int groupNumber;
  @Column
  private String unit;

  @JsonManagedReference
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "catagory_id")
  private Category category;
}
