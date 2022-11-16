package com.kviz.jnews.service;

import com.kviz.jnews.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    void save(News news);
    boolean isExist(String newsTitle);
    List<News> getAllNews();
    News getNews(String newsTitle);
}
