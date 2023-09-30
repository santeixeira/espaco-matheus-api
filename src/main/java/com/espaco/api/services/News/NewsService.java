package com.espaco.api.services.News;

import com.espaco.api.models.News;
import com.espaco.api.validators.NewsDTO;

import java.util.List;

public interface NewsService {
    List<News> getAll();
    News createNews(NewsDTO newsDTO);
    void deleteNews(Long id);
    News getByTitle(String title);
    News getById(Long id);
}
