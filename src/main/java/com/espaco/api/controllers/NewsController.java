package com.espaco.api.controllers;

import com.espaco.api.models.News;
import com.espaco.api.services.News.NewsService;
import com.espaco.api.utils.ServerRoutines;
import com.espaco.api.validators.NewsDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@CrossOrigin(value = {"https://matheuscarneiro.netlify.app", "https://matheuscarneiro.art"})
@RequestMapping("/api")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping("/noticia")
    public ResponseEntity<List<News>> getAll() {
        return ResponseEntity.ok().body(newsService.getAll());
    }

    @GetMapping("/noticia/{id}")
    public ResponseEntity<News> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(newsService.getById(id));
    }

    @PostMapping("/noticia/create")
    public ResponseEntity<News> createNews(@RequestBody @Valid NewsDTO newsDTO) {
        URI uri = ServerRoutines.toUri("/noticia/create");
        News news = newsService.createNews(newsDTO);
        return ResponseEntity.created(uri).body(news);
    }

    @DeleteMapping("/noticia/delete/{id}")
    public ResponseEntity<?> deleteNew(@PathVariable Long id) {
        newsService.deleteNews(id);
        return ResponseEntity.ok().build();
    }
}