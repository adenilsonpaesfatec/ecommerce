package br.com.ecommerce.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemPedidoDTO {
    private Long id;
    private Integer quantidade;
    private BigDecimal preco;
    private ProdutoDTO produto;
    
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
	public ProdutoDTO getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
    
}
