package com.spring.travelbook.service;

import com.spring.travelbook.entity.Civilian;

import java.util.List;

public interface CivilianService {
  List<Civilian> findAllFamilyMemberByUser(Long id);
  List<Civilian> findAll();
}
