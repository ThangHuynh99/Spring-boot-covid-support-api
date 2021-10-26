package com.spring.travelbook.service;

import com.spring.travelbook.dto.DistrictDTO;

import java.util.List;

public interface DistrictService {
    List<DistrictDTO> findAll();
}
