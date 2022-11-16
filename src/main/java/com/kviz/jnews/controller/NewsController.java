package com.kviz.jnews.controller;

import com.kviz.jnews.model.News;
import com.kviz.jnews.service.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping(value = "/news")
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }
}
