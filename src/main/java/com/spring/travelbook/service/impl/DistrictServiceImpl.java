package com.spring.travelbook.service.impl;

import com.spring.travelbook.converter.DistrictConverter;
import com.spring.travelbook.dto.DistrictDTO;
import com.spring.travelbook.repository.DistrictRepository;
import com.spring.travelbook.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private DistrictConverter districtConverter;

    @Override
    public List<DistrictDTO> findAll() {
        return districtRepository.findAll().stream().map(result -> districtConverter.toDTO(result))
                .collect(Collectors.toList());
    }
}
