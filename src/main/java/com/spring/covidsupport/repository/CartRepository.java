package com.spring.covidsupport.repository;

import com.spring.covidsupport.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
  @Query(value = "select * from cart where user_id = ?1", nativeQuery = true)
  List<Cart> findByUserCart(long id);

  List<Cart> findByWardNameAndGroupNumberAndDistrict(
      String wardName, Long groupNumber, String District);

  @Query(value = "select * from cart where user_id = ?1 and status =?2", nativeQuery = true)
  List<Cart> findByUserCartAndStatus(long id, int status);
}
