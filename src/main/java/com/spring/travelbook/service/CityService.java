package com.spring.travelbook.service;

import com.spring.travelbook.dto.CityDTO;
import com.spring.travelbook.entity.City;

import java.util.List;

public interface CityService {
    List<CityDTO> findAll();
}
