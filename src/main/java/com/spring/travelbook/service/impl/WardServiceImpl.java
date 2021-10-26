package com.spring.travelbook.service.impl;

import com.spring.travelbook.converter.WardConverter;
import com.spring.travelbook.dto.WardDTO;
import com.spring.travelbook.repository.WardRepository;
import com.spring.travelbook.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WardServiceImpl implements WardService {
    @Autowired
    private WardRepository wardRepository;
    @Autowired
    private WardConverter wardConverter;

    @Override
    public List<WardDTO> findAll() {
        return wardRepository.findAll().stream().map(result -> wardConverter.toDTO(result))
                .collect(Collectors.toList());
    }

    @Override
    public List<WardDTO> findByDistrictId(long district_id) {
        return wardRepository.findByDistrictId(district_id).stream().map(result -> wardConverter.toDTO(result))
                .collect(Collectors.toList());
    }
}
