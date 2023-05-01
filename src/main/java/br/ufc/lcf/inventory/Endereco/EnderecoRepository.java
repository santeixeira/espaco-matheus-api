package br.ufc.lcf.inventory.Endereco;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends MongoRepository<Endereco, String> {
  List<Endereco> findById();
}

