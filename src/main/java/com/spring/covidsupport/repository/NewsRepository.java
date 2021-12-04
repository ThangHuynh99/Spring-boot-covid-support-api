package com.spring.covidsupport.repository;

import com.spring.covidsupport.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
