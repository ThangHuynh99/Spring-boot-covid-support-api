package com.spring.covidsupport.repository;

import com.spring.covidsupport.entity.News;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllByDistrictAndWardNameAndGroupNumber(String district, String wardName, long groupNumber, Sort sort);
}
