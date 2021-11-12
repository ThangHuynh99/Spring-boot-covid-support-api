package com.spring.travelbook.controller;

import com.spring.travelbook.constant.RoleName;
import com.spring.travelbook.entity.UserEntity;
import com.spring.travelbook.service.UserService;
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

  @ApiOperation(value = "View list users", response = List.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/")
  public ResponseEntity<List<UserEntity>> getUsers(
      @RequestParam(value = "page", defaultValue = "1", required = false) int page) {
    Pageable pageable = PageRequest.of(page - 1, 20);

    return ResponseEntity.ok().body(userService.findAll(pageable));
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
}
