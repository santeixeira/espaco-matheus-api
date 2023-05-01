package br.ufc.lcf.inventory.Fornecedor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FornecedorServiceImpl implements FornecedorService{
  @Autowired
  private FornecedorRepository fornecedorRepository;
  @Override
  public Page<Fornecedor> getFornecedores(int page, int size) {
    return fornecedorRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  public Fornecedor postFornecedor(FornecedorDTO fornecedorDTO) {
    Fornecedor fornecedor = new Fornecedor(
            null,
            fornecedorDTO.nome(),
            fornecedorDTO.cnpj(),
            fornecedorDTO.telefone(),
            fornecedorDTO.email(),
            true,
            fornecedorDTO.tipo(),
            fornecedorDTO.endereco()
    );
    return fornecedorRepository.save(fornecedor);
  }

  @Override
  public Fornecedor updateFornecedor(String id) {
    return null;
  }

  @Override
  public void icognitoFornecedor(String id) {
    Fornecedor fornecedor = fornecedorRepository.findById(id).get();
    if (!fornecedor.getStatus()) {
      log.error("Fornecedor {} já está anonimizado. Para reativar, acionar administração.", fornecedor.getNome());
    }
    fornecedor.setStatus(false);
  }
}
