package br.com.ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetodoPagamentoDTO {

    private Long id;

    @NotNull(message = "O campo 'tipo' é obrigatório")
    private String tipo;

    private String descricao;
}
