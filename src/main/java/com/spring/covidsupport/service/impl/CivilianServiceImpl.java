package com.spring.covidsupport.service.impl;

import com.spring.covidsupport.constant.VaccineStatus;
import com.spring.covidsupport.converter.CivilianConverter;
import com.spring.covidsupport.converter.VaccineConverter;
import com.spring.covidsupport.dto.CivilianDTO;
import com.spring.covidsupport.dto.VaccineDTO;
import com.spring.covidsupport.entity.Civilian;
import com.spring.covidsupport.entity.UserEntity;
import com.spring.covidsupport.entity.Vaccine;
import com.spring.covidsupport.repository.CivilianRepository;
import com.spring.covidsupport.repository.UserRepository;
import com.spring.covidsupport.repository.VaccineRepository;
import com.spring.covidsupport.service.CivilianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CivilianServiceImpl implements CivilianService {
  @Autowired private CivilianRepository civilianRepository;
  @Autowired private UserRepository userRepository;
  @Autowired private CivilianConverter civilianConverter;
  @Autowired private VaccineRepository vaccineRepository;
  @Autowired private VaccineConverter vaccineConverter;

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
   *
   * @param civilian
   */
  @Override
  public ResponseEntity<Civilian> saveOrUpdateCivilians(CivilianDTO civilian) {
    Civilian result = new Civilian();
    if (civilian.getId() == 0) {
      UserEntity family = userRepository.getById(civilian.getFamilyId());
      result = save(civilian, family);
    } else {
      result = update(civilian);
    }
    return ResponseEntity.ok(result);
  }

  /**
   * this method use to delete civilian
   *
   * @param id
   */
  @Override
  public void delete(Long id) {
    civilianRepository.deleteById(id);
  }

  /**
   * this method use to save each civilian
   *
   * @param dto
   * @param family
   */
  private Civilian save(CivilianDTO dto, UserEntity family) {
    Civilian civilian = civilianConverter.toEntity(dto);
    civilian.setUser(family);
    storeVaccineStatus(dto, civilian);
    Civilian result = civilianRepository.save(civilian);
    if (dto.getVaccineList() != null) {
      List<Vaccine> vaccineList = new ArrayList<>();
      for (VaccineDTO data : dto.getVaccineList()) {
        vaccineList.add(saveVaccine(data, result));
      }
      result.setVaccineList(vaccineList);
    }
    return result;
  }

  /**
   * this method use to update each civilian
   *
   * @param dto
   */
  public Civilian update(CivilianDTO dto) {
    Civilian civilian = civilianRepository.getById(dto.getId());
    civilian = civilianConverter.toUpdateEntity(dto, civilian);
    storeVaccineStatus(dto, civilian);
    civilian = civilianRepository.save(civilian);
    if (dto.getVaccineList() != null) {
      int oldVaccineSize = civilian.getVaccineList() != null ? civilian.getVaccineList().size() : 0;
      if (dto.getVaccineList().size() >= oldVaccineSize) {
        List<Vaccine> vaccineList = new ArrayList<>();
        for (VaccineDTO data : dto.getVaccineList()) {
          if (data.getId() == null) {
            vaccineList.add(saveVaccine(data, civilian));
          } else {
            Vaccine oldVaccine = vaccineRepository.getById(data.getId());
            vaccineList.add(updateVaccine(data, oldVaccine));
          }
        }
        civilian.setVaccineList(vaccineList);
      }
    }
    return civilian;
  }

  /**
   * this method use to setVaccineStatus to civilian
   *
   * @param dto, entity
   */
  private void storeVaccineStatus(CivilianDTO dto, Civilian entity) {
    if (dto.getVaccineList() != null) {
      int vaccineShots = dto.getVaccineList().size();
      switch (vaccineShots) {
        case 1:
          entity.setVaccineStatus(VaccineStatus.ONE_SHOT);
          break;
        case 2:
          entity.setVaccineStatus(VaccineStatus.TWO_SHOT);
          break;
      }
    } else {
      entity.setVaccineStatus(VaccineStatus.NONE);
    }
  }

  private Vaccine updateVaccine(VaccineDTO dto, Vaccine oldVaccine) {
    return vaccineRepository.save(vaccineConverter.toUpdateEntity(dto, oldVaccine));
  }

  private Vaccine saveVaccine(VaccineDTO dto, Civilian civilian) {
    Vaccine data = vaccineConverter.toEntity(dto);
    data.setCivilian(civilian);
    return vaccineRepository.save(data);
  }
}
