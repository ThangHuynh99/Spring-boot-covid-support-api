package com.spring.covidsupport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderDTO extends Abstract{
    private String name;
    private Long quantity;
    private String price;
    private String totalPrice;
}
