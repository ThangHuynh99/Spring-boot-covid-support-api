package com.spring.covidsupport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart extends Base {
  @Column
  private int status;
  @Column
  private Long totalPrice;
  @Column
  private Long quantityProduct;
  @Column
  private String cartNumber;

  @JsonManagedReference
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(
      name = "product_cart",
      joinColumns = @JoinColumn(name = "cart_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Product> productList;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity userCart;
}
