package com.spring.covidsupport.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String userName;
    private String passWord;
    private Long groupNumber;
    private String wardName;
}
