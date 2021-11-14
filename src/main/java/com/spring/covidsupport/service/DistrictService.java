package com.spring.covidsupport.service;

import com.spring.covidsupport.dto.DistrictDTO;

import java.util.List;

public interface DistrictService {
    List<DistrictDTO> findAll();
}
