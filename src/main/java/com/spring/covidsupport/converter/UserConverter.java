package com.spring.covidsupport.converter;

import com.spring.covidsupport.dto.UserDTO;
import com.spring.covidsupport.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Date;

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
        userEntity.setAddress(dto.getAddress());
        userEntity.setName((dto.getName()));
        userEntity.setPhone(dto.getPhone());
        userEntity.setEmail(dto.getEmail());
        userEntity.setDistrict(dto.getDistrict());
        userEntity.setWardName(dto.getWardName());
        userEntity.setAddress(dto.getAddress());
        userEntity.setGender(dto.getGender());
        userEntity.setBirthDay(dto.getBirthDay());
        userEntity.setGroupNumber(dto.getGroupNumber());
    return userEntity;
    }

    public UserEntity toUpdateAdminEntity(UserDTO dto, UserEntity userEntity) {
        userEntity.setAddress(dto.getAddress());
        userEntity.setPhone(dto.getPhone());
        userEntity.setEmail(dto.getEmail());
        userEntity.setName(dto.getName());
        userEntity.setGender(dto.getGender());
        userEntity.setBirthDay(dto.getBirthDay());
        return userEntity;
    }
}
