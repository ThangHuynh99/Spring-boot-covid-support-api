package com.spring.travelbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "civilian")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Civilian extends Base{
    @Column
    private String name;
    @Column
    private String age;
    @Column
    private String gender;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private Date birthDay;
    @Column
    private String  wardName;

}
