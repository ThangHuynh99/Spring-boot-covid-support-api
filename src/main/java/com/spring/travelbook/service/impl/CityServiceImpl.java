package com.spring.travelbook.service.impl;

import com.spring.travelbook.converter.CityConverter;
import com.spring.travelbook.dto.CityDTO;
import com.spring.travelbook.repository.CityRepository;
import com.spring.travelbook.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CityConverter cityConverter;

    @Override
    public List<CityDTO> findAll() {
        return cityRepository.findAll().stream().map(result -> cityConverter
                .toDTO(result))
                .collect(Collectors.toList());
    }
}
