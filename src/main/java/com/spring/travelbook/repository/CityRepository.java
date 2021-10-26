package com.spring.travelbook.repository;

import com.spring.travelbook.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
