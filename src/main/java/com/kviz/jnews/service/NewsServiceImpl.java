package com.kviz.jnews.service;

import com.kviz.jnews.model.News;
import com.kviz.jnews.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository repository;

    @Override
    public void save(News news) {
        log.info("Save: {}", news);
        repository.save(news);
    }

    @Override
    public boolean isExist(String newsTitle) {
        log.info("isExist: {}", newsTitle);
        return repository.findAll().stream()
                .anyMatch(news -> news.getTitle().equals(newsTitle));
    }

    @Override
    public List<News> getAllNews() {
        log.info("getAllNews");
        return repository.findAll();
    }

    @Override
    public News getNews(String newsTitle) {
        log.info("getNews by Title : {}", newsTitle);
        return repository.findByTitle(newsTitle);
    }
}
