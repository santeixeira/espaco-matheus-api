package br.ufc.lcf.inventory.Storage;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface GalleryRepository extends MongoRepository<Gallery, String> {
    @Query(value = "{}", fields = "{'id':  1}")
    List<Gallery> getAll();

    List<Gallery> findByDescription(String description);
}
