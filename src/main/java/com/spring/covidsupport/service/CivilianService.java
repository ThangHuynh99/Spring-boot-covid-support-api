package com.spring.covidsupport.service;

import com.spring.covidsupport.dto.CivilianDTO;
import com.spring.covidsupport.entity.Civilian;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CivilianService {
  List<Civilian> findAllFamilyMemberByUser(Long id);

  List<Civilian> findAll();

  ResponseEntity<Civilian> saveOrUpdateCivilians(CivilianDTO civilian);

  void delete(Long id);
}
