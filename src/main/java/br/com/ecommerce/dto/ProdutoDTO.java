package br.com.ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;

    @NotNull(message = "O campo 'nome' é obrigatório")
    private String nome;

    private String descricao;

    @NotNull(message = "O campo 'preco' é obrigatório")
    private BigDecimal preco;

    private Integer estoque;

    private CategoriaDTO categoria;
}
