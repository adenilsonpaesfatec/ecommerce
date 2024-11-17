package br.com.ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

import br.com.ecommerce.model.CategoriaModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;

    @NotNull(message = "O campo 'nome' é obrigatório")
    @Size(min = 2, max = 100, message = "O campo 'nome' deve ter entre 2 e 100 caracteres")
    private String nome;

    @Size(max = 255, message = "O campo 'descricao' pode ter no máximo 255 caracteres")
    private String descricao;

    @NotNull(message = "O campo 'preco' é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O campo 'preco' deve ser maior que zero")
    private BigDecimal preco;

    @NotNull(message = "O campo 'estoque' é obrigatório")
    @Min(value = 0, message = "O campo 'estoque' deve ser zero ou maior")
    private Integer estoque;

    @NotNull(message = "O campo 'categoria' é obrigatório")
    private CategoriaModel categoria;
    
}
