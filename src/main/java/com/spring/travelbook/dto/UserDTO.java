package com.spring.travelbook.dto;

import com.spring.travelbook.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends Abstract{
    private String name;
    private String userName;
    private String passWord;
    private String age;
    private String gender;
    private String address;
    private String phone;
    private String email;
    private Date birthDay;
    private List<RoleEntity> roles = new ArrayList<>();
}
