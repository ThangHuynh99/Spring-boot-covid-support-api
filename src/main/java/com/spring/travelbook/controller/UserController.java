package com.spring.travelbook.controller;

import com.spring.travelbook.entity.Civilian;
import com.spring.travelbook.entity.User;
import com.spring.travelbook.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok().body(userService.findAll());
  }

  @ApiOperation(value = "View user by name", response = User.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @ApiParam(value = "name of user")
  @GetMapping("/{name}")
  public ResponseEntity<User> getUserByName(@PathVariable("name") String name) {
    return ResponseEntity.ok().body(userService.findByName(name));
  }

  @ApiOperation(value = "View user by email", response = User.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/email/{email}")
  public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
    return ResponseEntity.ok().body(userService.findByEmail(email));
  }

  @ApiOperation(value = "View user by username", response = User.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/username/{username}")
  public ResponseEntity<User> getUserByUserName(@PathVariable("userName") String userName) {
    return ResponseEntity.ok().body(userService.findByUserName(userName));
  }

  @ApiOperation(value = "Save user to database", response = User.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PostMapping("")
  public ResponseEntity<User> save(@RequestBody User user) {
    return ResponseEntity.ok().body(userService.save(user));
  }
}
