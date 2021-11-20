package com.spring.covidsupport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CivilianDTO extends Abstract{
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String birthDay;
    private String cccd;
    private Long familyId;
    private List<VaccineDTO> vaccineList;
}
