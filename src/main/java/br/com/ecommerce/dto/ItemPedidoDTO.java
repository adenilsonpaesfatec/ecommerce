package br.com.ecommerce.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

import br.com.ecommerce.model.PedidoModel;
import br.com.ecommerce.model.ProdutoModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {

    private Long id;

    @NotNull(message = "O campo 'quantidade' é obrigatório")
    @Min(value = 1, message = "A 'quantidade' deve ser no mínimo 1")
    private Integer quantidade;

    @NotNull(message = "O campo 'preco' é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O 'preco' deve ser maior que zero")
    private BigDecimal preco;

    @NotNull(message = "O campo 'pedido' é obrigatório")
    private PedidoModel pedido;

    @NotNull(message = "O campo 'produto' é obrigatório")
    private ProdutoModel produto;
    
}
