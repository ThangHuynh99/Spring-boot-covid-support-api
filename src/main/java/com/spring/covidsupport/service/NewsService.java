package com.spring.covidsupport.service;

import com.spring.covidsupport.entity.News;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NewsService {
    News save(News news);
    News findOne(Long id);
    List<News> findAll();
    ResponseEntity<?> update(News news);
    void delete(Long id);
}
