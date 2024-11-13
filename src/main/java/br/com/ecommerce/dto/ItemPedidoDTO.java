package br.com.ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {

    private Long id;

    @NotNull(message = "O campo 'quantidade' é obrigatório")
    private Integer quantidade;

    private BigDecimal preco;

    private ProdutoDTO produto;
}
