package br.ufc.lcf.inventory.Fornecedor;

import br.ufc.lcf.inventory.Endereco.Endereco;
import br.ufc.lcf.inventory.Fornecedor.Enum.Tipo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record FornecedorDTO(
        @NotNull @NotEmpty String nome,
        @NotNull @NotEmpty String cnpj,
        @NotNull @NotEmpty String telefone,
        @NotNull @NotEmpty @Email String email,
        @NotNull Tipo tipo,
        @NotNull Endereco endereco
) {

}
