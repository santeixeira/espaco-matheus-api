package br.ufc.lcf.inventory.Fornecedor;

import br.ufc.lcf.inventory.Endereco.Endereco;
import br.ufc.lcf.inventory.Fornecedor.Enum.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "fornecedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor {
  @MongoId
  private String id;
  private String nome;
  private String cnpj;
  private String telefone;
  private String email;
  private Boolean status;
  private Tipo tipo;
  private Endereco endereco;
}