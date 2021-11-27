package com.spring.covidsupport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO extends Abstract{
    private String name;
    private String code;
    private Long quantity;
    private String price;
    private String product_image;
    private String description;
    private boolean status;
    private int groupNumber;
    private CategoryDTO category;
    private String catalogType;
    private String wardName;
    private String unit;
}
