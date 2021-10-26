package com.spring.travelbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "family_information")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyInformation extends Base{
    private String familyName;
    @Column
    private String userName;
    @Column
    private String passWord;
    @Column
    private int groupNumber;
    @Column
    private String address;
}
