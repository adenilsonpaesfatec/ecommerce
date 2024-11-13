package br.com.ecommerce.dto;

import lombok.*;
import br.com.ecommerce.model.RoleModel;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    
    private Long id;

    @NotNull(message = "O campo 'email' é obrigatório")
    @Email(message = "O campo 'email' deve conter um endereço de e-mail válido")
    @Size(max = 100, message = "O campo 'email' pode ter no máximo 100 caracteres")
    private String email;

    @NotNull(message = "O campo 'senha' é obrigatório")
    @Size(min = 6, max = 20, message = "O campo 'senha' deve ter entre 6 e 20 caracteres")
    private String senha;

    private RoleModel role;
}
