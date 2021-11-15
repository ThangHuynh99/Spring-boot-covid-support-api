package com.spring.covidsupport.controller;

import com.spring.covidsupport.constant.RoleName;
import com.spring.covidsupport.dto.UserDTO;
import com.spring.covidsupport.entity.UserEntity;
import com.spring.covidsupport.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  @Autowired private UserService userService;

  @ApiOperation(value = "View list users", response = UserEntity.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("")
  public ResponseEntity<List<UserEntity>> getUsers(
      @RequestParam(value = "page", defaultValue = "1", required = false) int page) {
    Pageable pageable = PageRequest.of(page - 1, 20);

    return ResponseEntity.ok().body(userService.findAll(pageable));
  }

  @ApiOperation(value = "View list users by ROLE_USER", response = UserEntity.class)
  @ApiResponses(
          value = {
                  @ApiResponse(code = 200, message = "Success"),
                  @ApiResponse(code = 401, message = "Unauthorization"),
                  @ApiResponse(code = 403, message = "Access denied"),
                  @ApiResponse(code = 404, message = "Bad request")
          })
  @GetMapping("/RoleUser")
  public ResponseEntity<List<UserEntity>> findAllByRoleUser(
          @RequestParam(value = "page", defaultValue = "1", required = false) int page) {
    Pageable pageable = PageRequest.of(page - 1, 20);

    return userService.findAllByRoleUser(pageable);
  }

  @ApiOperation(value = "View user by name", response = UserEntity.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @ApiParam(value = "name of user")
  @GetMapping("/{name}")
  public ResponseEntity<UserEntity> getUserByName(@PathVariable("name") String name) {
    return ResponseEntity.ok().body(userService.findByName(name));
  }

  @ApiOperation(value = "View user by email", response = UserEntity.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/email/{email}")
  public ResponseEntity<UserEntity> getUserByEmail(@PathVariable("email") String email) {
    return ResponseEntity.ok().body(userService.findByEmail(email));
  }

  @ApiOperation(value = "View user by username", response = UserEntity.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/username/{userName}")
  public ResponseEntity<UserEntity> getUserByUserName(@PathVariable("userName") String userName) {
    return ResponseEntity.ok().body(userService.findByUserName(userName));
  }

  @ApiOperation(value = "Save role to user", response = Void.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PostMapping("/saveRole")
  public ResponseEntity<Void> saveRoleToUser(
      @RequestParam(value = "userName") String userName,
      @RequestParam(value = "roleName") RoleName roleName) {
    userService.saveRoleToUser(userName, roleName);
    return ResponseEntity.ok().build();
  }

  @ApiOperation(value = "Update current user", response = UserEntity.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PutMapping("")
  public ResponseEntity<?> update(@RequestBody UserDTO userDTO) {
    return userService.update(userDTO);
  }

  @ApiOperation(value = "Update admin and manager account", response = UserEntity.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PutMapping("/admin")
  public ResponseEntity<?> updateAdmin(@RequestBody UserDTO userDTO) {
    return userService.updateAdmin(userDTO);
  }

  @ApiOperation(value = "Update admin and manager account", response = UserEntity.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PutMapping("/password/{id}/{newPassword}")
  public ResponseEntity<?> changePassword(
      @PathVariable("id") Long id, @PathVariable("newPassword") String newPassword) {
    return userService.changePassword(id, newPassword);
  }
}
