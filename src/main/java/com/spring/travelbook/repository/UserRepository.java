package com.spring.travelbook.repository;

import com.spring.travelbook.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserName(String userName);

    @Query("SELECT u FROM UserEntity u WHERE u.name = ?1")
//    @Query(value = "SELECT u FROM user u WHERE u.name = ?1", nativeQuery = true)
    UserEntity findByName(String name);

    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
}
