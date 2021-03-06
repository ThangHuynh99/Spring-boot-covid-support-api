package com.spring.covidsupport.repository;

import com.spring.covidsupport.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward, Long> {
    @Query(value = "select * from ward where district_id = ?1", nativeQuery = true)
    List<Ward> findByDistrictId(long id);

    Ward findByName(String name);
}
