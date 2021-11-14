package com.spring.covidsupport.service.impl;

import com.spring.covidsupport.converter.CityConverter;
import com.spring.covidsupport.dto.CityDTO;
import com.spring.covidsupport.repository.CityRepository;
import com.spring.covidsupport.service.CityService;
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
