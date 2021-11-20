package com.spring.covidsupport.service.impl;

import com.spring.covidsupport.constant.VaccineStatus;
import com.spring.covidsupport.converter.CivilianConverter;
import com.spring.covidsupport.dto.CivilianDTO;
import com.spring.covidsupport.entity.Civilian;
import com.spring.covidsupport.entity.UserEntity;
import com.spring.covidsupport.repository.CivilianRepository;
import com.spring.covidsupport.repository.UserRepository;
import com.spring.covidsupport.service.CivilianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CivilianServiceImpl implements CivilianService {
  @Autowired private CivilianRepository civilianRepository;
  @Autowired private UserRepository userRepository;
  @Autowired private CivilianConverter civilianConverter;

  @Override
  public List<Civilian> findAllFamilyMemberByUser(Long id) {
    return civilianRepository.findAllFamilyMemberByUser(id);
  }

  @Override
  public List<Civilian> findAll() {
    return civilianRepository.findAll();
  }

  /**
   * this method use to update or insert a list of civilians
   * @param civilians
   */
  @Override
  public ResponseEntity<List<Civilian>> saveOrUpdateCivilians(List<CivilianDTO> civilians) {
    Long familyId = civilians.get(0).getFamilyId();
    UserEntity family = userRepository.getById(familyId);
    List<Civilian> result = new ArrayList<>();
    if (family.getCivilians().size() == 0) {
      result = civilians.stream().map(data -> saveEach(data, family)).collect(Collectors.toList());
    } else {
      result = civilians.stream().map(data -> updateEach(data)).collect(Collectors.toList());
    }
    return ResponseEntity.ok(result);
  }

  /**
   * this method use to delete civilian
   * @param id
   */
  @Override
  public void delete(Long id) {
    civilianRepository.deleteById(id);
  }

  /**
   * this method use to save each civilian
   * @param dto
   * @param family
   */
  private Civilian saveEach(CivilianDTO dto, UserEntity family) {
    Civilian civilian = civilianConverter.toEntity(dto);
    civilian.setUser(family);
    storeVaccineStatus(civilian);
    return civilianRepository.save(civilian);
  }

  /**
   * this method use to update each civilian
   * @param dto
   */
  public Civilian updateEach(CivilianDTO dto) {
    Civilian civilian = civilianRepository.getById(dto.getId());
    civilian = civilianConverter.toUpdateEntity(dto, civilian);
    storeVaccineStatus(civilian);
    return civilianRepository.save(civilian);
  }

  /**
   * this method use to setVaccineStatus to civilian
   * @param civilian
   */
  private void storeVaccineStatus(Civilian civilian) {
    int vaccineShots = civilian.getVaccineList().size();
    switch (vaccineShots) {
      case 1:
        civilian.setVaccineStatus(VaccineStatus.ONE_SHOT);
        break;
      case 2:
        civilian.setVaccineStatus(VaccineStatus.TWO_SHOT);
        break;
      default:
        civilian.setVaccineStatus(VaccineStatus.NONE);
    }
  }
}
