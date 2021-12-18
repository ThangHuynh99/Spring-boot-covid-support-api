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
  private String ownerName;
  @Column
  private String cartCode;
  @Column
  private int status;
  @Column
  private Long totalPrice;
  @Column
  private Long quantityProduct;
  @Column
  private String phoneNumber;
  @Column
  private String wardName;
  @Column
  private Long groupNumber;
  @Column
  private String district;
  @Column
  private String address;

  @JsonManagedReference
  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
  private List<ProductOrder> listProduct;

  @JsonBackReference
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private UserEntity userCart;
}
