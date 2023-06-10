package br.ufc.lcf.inventory.services;

import br.ufc.lcf.inventory.entity.NewsDTO;
import br.ufc.lcf.inventory.model.News;

import java.util.List;

public interface NewsService {
    List<News> getAll();

    News createNews(NewsDTO newsDTO);

    void deleteNews(String id);

    News getByTitle(String title);

    News getById(String id);
}
