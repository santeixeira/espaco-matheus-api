package br.ufc.lcf.inventory.Fornecedor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FornecedorService {
  Page<Fornecedor> getFornecedores(int page, int size);

  Fornecedor postFornecedor(FornecedorDTO fornecedorDTO);

  Fornecedor updateFornecedor(String id);

  void icognitoFornecedor(String id);
}
