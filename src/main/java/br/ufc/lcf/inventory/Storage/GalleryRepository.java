package br.ufc.lcf.inventory.Storage;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GalleryRepository extends MongoRepository<Gallery, String> {
    List<Gallery> findByDescription(String description);
}
