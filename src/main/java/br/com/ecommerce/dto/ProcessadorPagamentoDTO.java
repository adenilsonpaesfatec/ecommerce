package br.com.ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessadorPagamentoDTO {

    private Long id;

    @NotNull(message = "O campo 'nome' é obrigatório")
    @Size(min = 2, max = 50, message = "O campo 'nome' deve ter entre 2 e 50 caracteres")
    private String nome;

    @Size(max = 255, message = "O campo 'configuracoes' pode ter no máximo 255 caracteres")
    private String configuracoes;

}