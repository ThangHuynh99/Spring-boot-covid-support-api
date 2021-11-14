package com.spring.covidsupport.converter;

import com.spring.covidsupport.dto.UserDTO;
import com.spring.covidsupport.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired
    private ModelMapper mapper;

    public UserEntity toEntity(UserDTO dto) {
        UserEntity entity = mapper.map(dto, UserEntity.class);
        return entity;
    }

    public UserDTO toDTO(UserEntity entity) {
        UserDTO dto = mapper.map(entity, UserDTO.class);
        return dto;
    }

    public UserEntity toEntity(UserDTO dto, UserEntity userEntity) {
        userEntity = mapper.map(dto, UserEntity.class);
        return userEntity;
    }
}
