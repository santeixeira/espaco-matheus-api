package com.espaco.api.services.News;

import com.espaco.api.models.News;
import com.espaco.api.repository.NewsRepository;
import com.espaco.api.validators.NewsDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
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
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    public News getByTitle(String title) {
        return newsRepository.findByTitle(title);
    }

    @Override
    public News getById(Long id) {
        return newsRepository.findById(id).orElseThrow();
    }
}
