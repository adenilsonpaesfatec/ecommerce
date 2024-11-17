package br.com.ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetodoPagamentoDTO {

    private Long id;

    @NotNull(message = "O campo 'tipo' é obrigatório")
    @Size(min = 2, max = 100, message = "O campo 'tipo' deve ter entre 2 e 100 caracteres")
    private String tipo;

    @Size(max = 255, message = "O campo 'descricao' pode ter no máximo 255 caracteres")
    private String descricao;
}
