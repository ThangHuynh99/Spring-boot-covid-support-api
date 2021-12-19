package com.spring.covidsupport.controller;

import com.spring.covidsupport.dto.CivilianDTO;
import com.spring.covidsupport.entity.Civilian;
import com.spring.covidsupport.service.CivilianService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/civilians")
public class CivilianController {
  @Autowired private CivilianService civilianService;

  @ApiOperation(value = "Find all faminy member by User", response = Civilian.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/{familyId}")
  public ResponseEntity<List<Civilian>> findAllFamilyMemberByUser(
      @PathVariable("familyId") Long familyId) {
    return ResponseEntity.ok(civilianService.findAllFamilyMemberByUser(familyId));
  }

  @ApiOperation(value = "Find all Civilian", response = Civilian.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("")
  public ResponseEntity<List<Civilian>> findAll() {
    return ResponseEntity.ok(civilianService.findAll());
  }

  @ApiOperation(value = "insert Civilian to family")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PostMapping("/family")
  public ResponseEntity<Civilian> saveCivilians(@RequestBody CivilianDTO civilian) {
    return civilianService.saveOrUpdateCivilians(civilian);
  }

  @ApiOperation(value = "update Civilians")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PutMapping("/family")
  public ResponseEntity<Civilian> updateCivilians(@RequestBody CivilianDTO civilian) {
    return civilianService.saveOrUpdateCivilians(civilian);
  }

  @ApiOperation(value = "Delete Civilian")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @DeleteMapping("/family/{civilianId}")
  public ResponseEntity deleteCivilian(@PathVariable("civilianId") Long id) {
    civilianService.delete(id);
    return ResponseEntity.ok().build();
  }
}
