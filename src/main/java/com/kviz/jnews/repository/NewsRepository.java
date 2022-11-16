package com.kviz.jnews.repository;

import com.kviz.jnews.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
    News findByTitle(String title);
}
