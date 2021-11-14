package com.spring.covidsupport.converter;

import com.spring.covidsupport.dto.DistrictDTO;
import com.spring.covidsupport.entity.District;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistrictConverter {
    @Autowired
    private ModelMapper mapper;

    public DistrictDTO toDTO(District entity) {
        return mapper.map(entity, DistrictDTO.class);
    }

    public District toEntity(DistrictDTO dto) {
        return mapper.map(dto, District.class);
    }
}
