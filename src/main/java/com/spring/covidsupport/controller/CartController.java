package com.spring.covidsupport.controller;

import com.spring.covidsupport.dto.CartDTO;
import com.spring.covidsupport.dto.LocationFiltterRequest;
import com.spring.covidsupport.entity.Cart;
import com.spring.covidsupport.service.CartService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
  @Autowired private CartService cartService;

  @ApiOperation(
      value =
          "Save new cart, when save cart then product in listProduct don't have id and"
              + " productId is id of product",
      response = Cart.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PostMapping("")
  public ResponseEntity<Cart> save(@RequestBody CartDTO cart) {
    return ResponseEntity.ok(cartService.save(cart));
  }

  @ApiOperation(value = "update cart status", response = Cart.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PutMapping("/{id}/{status}")
  public ResponseEntity<?> updateCartStatus(
      @PathVariable("id") Long id, @PathVariable("status") int status) {
    return cartService.updateCartStatus(id, status);
  }

  @ApiOperation(value = "get cart by id", response = Cart.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/{idCart}")
  public ResponseEntity<Cart> getOne(@PathVariable("idCart") long idCart) {
    return ResponseEntity.ok().body(cartService.getOne(idCart));
  }

  @ApiOperation(value = "get all cart by user", response = Cart.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/user/{idUser}")
  public ResponseEntity<List<Cart>> getByUser(@PathVariable("idUser") Long idUser) {
    return ResponseEntity.ok(cartService.getByUser(idUser));
  }

  @ApiOperation(value = "get all cart by userId and status cart", response = Cart.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/user/{idUser}/{status}")
  public ResponseEntity<List<Cart>> getByUserAndStatus(
      @PathVariable("idUser") Long idUser, @PathVariable("status") int status) {
    return ResponseEntity.ok(cartService.getByUserAndStatus(idUser, status));
  }

  @ApiOperation(
      value = "get all cart by destination (ward, district, groupNumber) and status",
      response = Cart.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PostMapping("location/{status}")
  public ResponseEntity<List<Cart>> getAllByDestination(
      @RequestBody LocationFiltterRequest filter, @PathVariable("status") int status) {
    return ResponseEntity.ok(cartService.getByDestinationAndStatus(filter, status));
  }
}
