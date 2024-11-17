package br.com.ecommerce.dto;

import lombok.*;
import br.com.ecommerce.model.ClienteModel;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    private Long id;

    @NotNull(message = "O campo 'logradouro' é obrigatório")
    @Size(max = 100, message = "O campo 'logradouro' pode ter no máximo 100 caracteres")
    private String logradouro;

    @NotNull(message = "O campo 'cidade' é obrigatório")
    @Size(max = 50, message = "O campo 'cidade' pode ter no máximo 50 caracteres")
    private String cidade;

    @NotNull(message = "O campo 'estado' é obrigatório")
    @Size(max = 20, message = "O campo 'estado' pode ter no máximo 20 caracteres")
    private String estado;

    @NotNull(message = "O campo 'cep' é obrigatório")
    @Size(max = 10, message = "O campo 'cep' pode ter no máximo 10 caracteres")
    private String cep;

    @NotNull(message = "O campo 'cliente' é obrigatório")
    private ClienteModel cliente;
}
