package br.ufc.lcf.inventory.Fornecedor;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends MongoRepository<Fornecedor, String> {
  Fornecedor findByCnpj(String cnpj);
  Fornecedor findByTipo(String tipo);
}
