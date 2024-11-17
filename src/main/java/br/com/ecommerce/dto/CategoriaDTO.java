package br.com.ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

import br.com.ecommerce.model.ProdutoModel;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {
	
    private Long id;

    @NotNull(message = "O campo 'nome' é obrigatório")
    @Size(min = 2, max = 100, message = "O campo 'nome' deve ter entre 2 e 100 caracteres")
    private String nome;

    @Size(max = 255, message = "O campo 'descricao' pode ter no máximo 255 caracteres")
    private String descricao;

    private List<ProdutoModel> produtos;
    
}
