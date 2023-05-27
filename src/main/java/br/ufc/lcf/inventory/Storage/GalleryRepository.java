package br.ufc.lcf.inventory.Storage;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface GalleryRepository extends MongoRepository<Gallery, String> {
    @Query(value = "{id:  ?0}", fields = "{id:  0}")
    List<Gallery> getAllIds(String id);
    List<Gallery> findByDescription(String description);
}
