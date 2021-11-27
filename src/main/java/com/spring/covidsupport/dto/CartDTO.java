package com.spring.covidsupport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO extends Abstract{
    private String ownerName;
    private String cartCode;
    private int status;
    private Long totalPrice;
    private Long quantityProduct;
    private String phoneNumber;
    private String district;
    private String wardName;
    private String groupNumber;
    private List<ProductOrderDTO> listProduct;
}
