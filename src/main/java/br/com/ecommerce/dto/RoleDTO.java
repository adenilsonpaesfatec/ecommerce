package br.com.ecommerce.dto;

import lombok.Data;
import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private Long id;

    @NotNull(message = "O campo 'nome' é obrigatório")
    @Size(min = 3, max = 50, message = "O campo 'nome' deve ter entre 3 e 50 caracteres")
    private String nome;
    
}
