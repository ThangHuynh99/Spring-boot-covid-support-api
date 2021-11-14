package com.spring.covidsupport.service.impl;

import com.spring.covidsupport.converter.WardConverter;
import com.spring.covidsupport.dto.WardDTO;
import com.spring.covidsupport.repository.WardRepository;
import com.spring.covidsupport.service.WardService;
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
