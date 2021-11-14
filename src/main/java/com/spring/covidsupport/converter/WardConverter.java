package com.spring.covidsupport.converter;

import com.spring.covidsupport.dto.WardDTO;
import com.spring.covidsupport.entity.Ward;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WardConverter {
    @Autowired
    private ModelMapper mapper;

    public WardDTO toDTO(Ward entity) {
        return mapper.map(entity, WardDTO.class);
    }

    public Ward toEntity(WardDTO dto) {
        return mapper.map(dto, Ward.class);
    }
}
