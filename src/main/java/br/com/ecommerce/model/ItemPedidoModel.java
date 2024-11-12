package br.com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
@Data
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public PedidoModel getPedido() {
		return pedido;
	}

	public void setPedido(PedidoModel pedido) {
		this.pedido = pedido;
	}

	public ProdutoModel getProduto() {
		return produto;
	}

	public void setProduto(ProdutoModel produto) {
		this.produto = produto;
	}

}
