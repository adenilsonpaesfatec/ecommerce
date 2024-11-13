package br.com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

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
    private Integer quantidade;

    @Column(name = "itp_preco", nullable = false)
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "ped_id", nullable = false)
    private PedidoModel pedido;

    @ManyToOne
    @JoinColumn(name = "prd_id", nullable = false)
    private ProdutoModel produto;

}
