package br.com.ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessadorPagamentoDTO {

    private Long id;

    @NotNull(message = "O campo 'nome' é obrigatório")
    private String nome;

    private String configuracoes;
}
