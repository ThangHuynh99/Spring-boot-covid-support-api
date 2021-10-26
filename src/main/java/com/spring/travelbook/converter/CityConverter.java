package com.spring.travelbook.converter;

import com.spring.travelbook.dto.CityDTO;
import com.spring.travelbook.entity.City;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityConverter {
    @Autowired
    private ModelMapper mapper;

    public CityDTO toDTO(City entity) {
        return mapper.map(entity, CityDTO.class);
    }

    public City toEntity(CityDTO dto) {
        return mapper.map(dto, City.class);
    }
}
