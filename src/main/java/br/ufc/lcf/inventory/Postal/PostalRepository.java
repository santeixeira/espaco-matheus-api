package br.ufc.lcf.inventory.Postal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostalRepository extends MongoRepository<Postal, String> {
    @Query("{'date':  {$regex: ?0}}")
    List<Postal> findByEmail();
}
