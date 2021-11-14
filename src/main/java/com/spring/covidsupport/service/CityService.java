package com.spring.covidsupport.service;

import com.spring.covidsupport.dto.CityDTO;

import java.util.List;

public interface CityService {
    List<CityDTO> findAll();
}
