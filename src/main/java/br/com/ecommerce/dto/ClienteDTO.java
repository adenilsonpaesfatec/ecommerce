package br.com.ecommerce.dto;

import lombok.*;
import br.com.ecommerce.model.UsuarioModel;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;

    @NotNull(message = "O campo 'nome' é obrigatório")
    @Size(min = 2, max = 100, message = "O campo 'nome' deve ter entre 2 e 100 caracteres")
    private String nome;

    @Size(max = 20, message = "O campo 'telefone' pode ter no máximo 20 caracteres")
    private String telefone;

    private UsuarioModel usuario;

}
