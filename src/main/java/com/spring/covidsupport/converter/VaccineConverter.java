package com.spring.covidsupport.converter;

import com.spring.covidsupport.dto.VaccineDTO;
import com.spring.covidsupport.entity.Vaccine;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VaccineConverter {
  @Autowired private ModelMapper mapper;

  public Vaccine toEntity(VaccineDTO dto) {
    Vaccine entity = mapper.map(dto, Vaccine.class);
    return entity;
  }

  public VaccineDTO toDTO(Vaccine entity) {
    VaccineDTO dto = mapper.map(entity, VaccineDTO.class);
    return dto;
  }

  public Vaccine toUpdateEntity(VaccineDTO dto, Vaccine oldEntity) {
    oldEntity.setDate(dto.getDate());
    oldEntity.setVaccineName(dto.getVaccineName());
    return oldEntity;
  }
}
