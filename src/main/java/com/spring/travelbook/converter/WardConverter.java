package com.spring.travelbook.converter;

import com.spring.travelbook.dto.UserDTO;
import com.spring.travelbook.dto.WardDTO;
import com.spring.travelbook.entity.UserEntity;
import com.spring.travelbook.entity.Ward;
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
