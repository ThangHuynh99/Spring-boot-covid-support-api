package com.spring.travelbook.converter;

import com.spring.travelbook.dto.UserDTO;
import com.spring.travelbook.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired
    private ModelMapper mapper;

    public UserDTO toDTO(UserEntity entity) {
        return mapper.map(entity, UserDTO.class);
    }

    public UserEntity toEntity(UserDTO dto) {
        return mapper.map(dto, UserEntity.class);
    }
}
