package com.spring.covidsupport.service;

import com.spring.covidsupport.entity.Civilian;

import java.util.List;

public interface CivilianService {
  List<Civilian> findAllFamilyMemberByUser(Long id);
  List<Civilian> findAll();
}
