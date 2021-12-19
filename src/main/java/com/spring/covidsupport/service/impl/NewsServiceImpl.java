package com.spring.covidsupport.service.impl;

import com.spring.covidsupport.dto.LocationFiltterRequest;
import com.spring.covidsupport.entity.News;
import com.spring.covidsupport.repository.NewsRepository;
import com.spring.covidsupport.response.MessageResponse;
import com.spring.covidsupport.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
  @Autowired private NewsRepository newsRepository;

  @Override
  public News save(News news) {
    return newsRepository.save(news);
  }

  @Override
  public News findOne(Long id) {
    return newsRepository.getById(id);
  }

  @Override
  public List<News> findAllByLocation(LocationFiltterRequest locationFiltterRequest) {
    return newsRepository.findAllByDistrictAndWardNameAndGroupNumber(
        locationFiltterRequest.getDistrict(),
        locationFiltterRequest.getWardName(),
        locationFiltterRequest.getGroupNumber(),
        Sort.by("modifiedDate").descending());
  }

  @Override
  public ResponseEntity<?> update(News news) {
    News oldNews = newsRepository.getById(news.getId());
    if (oldNews == null) {
      return ResponseEntity.badRequest().body(new MessageResponse("News does not exist"));
    }
    oldNews = toUpdate(oldNews, news);
    return ResponseEntity.ok(newsRepository.save(oldNews));
  }

  @Override
  public void delete(Long id) {
    newsRepository.deleteById(id);
  }

  private News toUpdate(News oldNew, News news) {
    oldNew.setContent(news.getContent());
    oldNew.setThumbnail(news.getThumbnail());
    oldNew.setShortDescription(news.getShortDescription());
    oldNew.setTitle(news.getTitle());
    return oldNew;
  }
}
