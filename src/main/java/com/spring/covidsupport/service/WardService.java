package com.spring.covidsupport.service;

import com.spring.covidsupport.dto.WardDTO;

import java.util.List;

public interface WardService {
    List<WardDTO> findAll();
    List<WardDTO> findByDistrictId(long district_id);
}
