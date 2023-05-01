package br.ufc.lcf.inventory.Endereco;

import org.springframework.data.domain.Page;

public interface EnderecoService {
  Page<Endereco> getEndereco(int page, int size);

  Endereco postUser(EnderecoDTO enderecoDTO);

  Endereco updateUser(String id);
}
