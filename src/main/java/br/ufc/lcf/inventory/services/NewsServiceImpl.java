package br.ufc.lcf.inventory.services;

import br.ufc.lcf.inventory.entity.NewsDTO;
import br.ufc.lcf.inventory.model.News;
import br.ufc.lcf.inventory.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Override
    public List<News> getAll() {
        return newsRepository.findAll(Sort.by("date").descending());
    }

    @Override
    public News createNews(NewsDTO newsDTO) {
        News data = News.builder()
                .title(newsDTO.title())
                .image(newsDTO.image())
                .description(newsDTO.description())
                .date(LocalDateTime.now())
                .build();
        return newsRepository.save(data);
    }

    @Override
    public void deleteNews(String id) {
        newsRepository.deleteById(id);
    }

    @Override
    public News getByTitle(String title) {
        return newsRepository.findByTitle(title);
    }

    @Override
    public News getById(String id) {
        return newsRepository.findById(id).orElseThrow();
    }
}
