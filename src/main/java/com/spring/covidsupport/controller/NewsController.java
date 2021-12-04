package com.spring.covidsupport.controller;

import com.spring.covidsupport.entity.News;
import com.spring.covidsupport.service.NewsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manager/news")
public class NewsController {
  @Autowired private NewsService newsService;

  @ApiOperation(value = "Save news", response = News.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PostMapping("")
  public ResponseEntity<News> save(@RequestBody News news) {
    return ResponseEntity.ok(newsService.save(news));
  }

  @ApiOperation(value = "Find news by id", response = News.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("/{id}")
  public ResponseEntity<News> findOne(
      @ApiParam(
              name = "id",
              type = "Long",
              value = "id is the primary key of news in table",
              example = "1")
          @PathVariable("id")
          Long id) {
    return ResponseEntity.ok(newsService.findOne(id));
  }

  @ApiOperation(value = "Find all news", response = News.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @GetMapping("")
  public ResponseEntity<List<News>> findAll() {
    return ResponseEntity.ok(newsService.findAll());
  }

  @ApiOperation(value = "update news", response = News.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @PutMapping("")
  public ResponseEntity<?> update(@RequestBody News news) {
    return newsService.update(news);
  }

  @ApiOperation(value = "delete news", response = News.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Unauthorization"),
        @ApiResponse(code = 403, message = "Access denied"),
        @ApiResponse(code = 404, message = "Bad request")
      })
  @DeleteMapping("{id}")
  public ResponseEntity<Void> update(
      @ApiParam(
              name = "id",
              type = "Long",
              value = "id is the primary key of news in table",
              example = "1")
          @PathVariable("id")
          Long id) {
    newsService.delete(id);
    return ResponseEntity.ok().build();
  }
}
