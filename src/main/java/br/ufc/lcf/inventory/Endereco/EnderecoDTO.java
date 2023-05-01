package br.ufc.lcf.inventory.Endereco;


import br.ufc.lcf.inventory.Endereco.Enum.UFEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record EnderecoDTO(
        @NotNull @NotEmpty String cep,
        @NotNull @NotEmpty String logradouro,
        @NotNull Integer numero,
        @NotNull @NotEmpty String complemento,
        @NotNull @NotEmpty String bairro,
        @NotNull @NotEmpty String cidade,
        @NotNull UFEnum uf

) {

}