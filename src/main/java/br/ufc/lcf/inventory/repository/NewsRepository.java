package br.ufc.lcf.inventory.repository;

import br.ufc.lcf.inventory.model.News;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<News, String> {
    News findByTitle(String title);
}
