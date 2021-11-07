package com.spring.travelbook.repository;

import com.spring.travelbook.entity.Civilian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CivilianRepository extends JpaRepository<Civilian, Long> {
    @Query(value = "SELECT * FROM civilian WHERE user_id = ?1", nativeQuery = true)
    List<Civilian> findAllFamilyMemberByUser(Long id);
}
