package com.espaco.api.repository;

import com.espaco.api.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
    News findByTitle(String title);
}
