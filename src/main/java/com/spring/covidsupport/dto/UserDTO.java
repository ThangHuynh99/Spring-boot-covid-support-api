package com.spring.covidsupport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO extends Abstract{
    private String familyName;
    private String userName;
    private String passWord;
    private String address;
    private String wardName;
    private Long groupNumber;
    private String phone;
    private String name;
    private String age;
    private String gender;
    private String email;
    private Date birthDay;
    private String district;
}
