package com.spring.covidsupport.converter;

import com.spring.covidsupport.dto.CivilianDTO;
import com.spring.covidsupport.entity.Civilian;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CivilianConverter {
    @Autowired
    private ModelMapper mapper;

    public Civilian toEntity(CivilianDTO dto) {
        Civilian entity = mapper.map(dto, Civilian.class);
        return entity;
    }

    public CivilianDTO toDTO(Civilian entity) {
        CivilianDTO dto = mapper.map(entity, CivilianDTO.class);
        return dto;
    }

    public Civilian toUpdateEntity(CivilianDTO dto, Civilian civilian) {
        Civilian entity = mapper.map(dto, Civilian.class);
        entity.setUser(civilian.getUser());
        entity.setCreatedBy(civilian.getCreatedBy());
        entity.setCreatedDate(civilian.getCreatedDate());
        return entity;
    }
}
