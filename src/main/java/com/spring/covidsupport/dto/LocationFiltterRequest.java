package com.spring.covidsupport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationFiltterRequest {
    private String district;
    private Long groupNumber;
    private String wardName;
}
