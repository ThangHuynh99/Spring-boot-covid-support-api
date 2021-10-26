package com.spring.travelbook.service;

import com.spring.travelbook.dto.WardDTO;

import java.util.List;

public interface WardService {
    List<WardDTO> findAll();
    List<WardDTO> findByDistrictId(long district_id);
}
