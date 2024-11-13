package br.com.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "itens_pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
public class ItemPedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itp_id")
    private Long id;

    @Column(name = "itp_quantidade", nullable = false)
    @NotNull(message = "O campo 'quantidade' é obrigatório")
    @Min(value = 1, message = "A 'quantidade' deve ser no mínimo 1")
    private Integer quantidade;

    @Column(name = "itp_preco", nullable = false)
    @NotNull(message = "O campo 'preco' é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O 'preco' deve ser maior que zero")
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "ped_id", nullable = false)
    @NotNull(message = "O campo 'pedido' é obrigatório")
    @JsonIgnore
    private PedidoModel pedido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prd_id", nullable = false)
    @NotNull(message = "O campo 'produto' é obrigatório")
    @JsonIgnore
    private ProdutoModel produto;

}
