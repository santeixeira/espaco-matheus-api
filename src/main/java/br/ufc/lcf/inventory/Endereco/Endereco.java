package br.ufc.lcf.inventory.Endereco;

import br.ufc.lcf.inventory.Endereco.Enum.UFEnum;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
  @MongoId
  private String id;
  private String cep;
  private String logradouro;
  private Integer numero;
  private String complemento;
  private String bairro;
  private String cidade;
  private UFEnum uf;

  public String ToString() {
    return String.format("%s, %d, %s, %s, %s - %s",
            this.getLogradouro(),
            this.getNumero(),
            this.getBairro(),
            this.getCidade(),
            this.getUf(),
            this.getCep());
  }
}
