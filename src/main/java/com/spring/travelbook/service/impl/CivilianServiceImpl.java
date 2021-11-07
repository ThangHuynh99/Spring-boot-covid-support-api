package com.spring.travelbook.service.impl;

import com.spring.travelbook.entity.Civilian;
import com.spring.travelbook.repository.CivilianRepository;
import com.spring.travelbook.service.CivilianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CivilianServiceImpl implements CivilianService {
  @Autowired private CivilianRepository civilianRepository;

  @Override
  public List<Civilian> findAllFamilyMemberByUser(Long id) {
    return civilianRepository.findAllFamilyMemberByUser(id);
  }

  @Override
  public List<Civilian> findAll() {
    return civilianRepository.findAll();
  }
}
