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
    private String nome;
    
}
