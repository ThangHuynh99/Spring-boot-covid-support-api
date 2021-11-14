package com.spring.covidsupport.repository;

import com.spring.covidsupport.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District, Long> {
}
