package br.ufc.lcf.inventory.Endereco;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EnderecoServiceImpl implements EnderecoService {

  @Autowired
  private EnderecoRepository enderecoRepo;

  @Override
  public Page<Endereco> getEndereco(int page, int size) {
    return enderecoRepo.findAll(PageRequest.of(page, size));
  }

  @Override
  public Endereco postUser(EnderecoDTO enderecoDTO) {
    return new Endereco(null,
            enderecoDTO.cep(),
            enderecoDTO.logradouro(),
            enderecoDTO.numero(),
            enderecoDTO.complemento(),
            enderecoDTO.bairro(),
            enderecoDTO.cidade(),
            enderecoDTO.uf());
  }

  @Override
  public Endereco updateUser(String id) {
    return null;
  }
}