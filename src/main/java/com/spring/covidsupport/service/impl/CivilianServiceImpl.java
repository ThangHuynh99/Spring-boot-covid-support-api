package com.spring.covidsupport.service.impl;

import com.spring.covidsupport.entity.Civilian;
import com.spring.covidsupport.repository.CivilianRepository;
import com.spring.covidsupport.service.CivilianService;
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
