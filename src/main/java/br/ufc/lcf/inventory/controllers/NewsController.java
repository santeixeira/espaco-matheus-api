package br.ufc.lcf.inventory.controllers;

import br.ufc.lcf.inventory.Util.General;
import br.ufc.lcf.inventory.entity.NewsDTO;
import br.ufc.lcf.inventory.model.News;
import br.ufc.lcf.inventory.services.NewsService;
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
    public ResponseEntity<News> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(newsService.getById(id));
    }

    @PostMapping("/noticia/create")
    public ResponseEntity<News> createNews(@RequestBody @Valid NewsDTO newsDTO) {
        URI uri = General.toUri("/noticia/create");
        News news = newsService.createNews(newsDTO);
        return ResponseEntity.created(uri).body(news);
    }

    @DeleteMapping("/noticia/delete/{id}")
    public ResponseEntity<?> deleteNew(@PathVariable String id) {
        newsService.deleteNews(id);
        return ResponseEntity.ok().build();
    }
}
