package com.spring.travelbook.repository;

import com.spring.travelbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    @Query("SELECT u FROM User u WHERE u.name = ?1")
//    @Query(value = "SELECT u FROM user u WHERE u.name = ?1", nativeQuery = true)
    User findByName(String name);
}
