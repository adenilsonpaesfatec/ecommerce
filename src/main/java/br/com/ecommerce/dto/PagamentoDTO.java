package br.com.ecommerce.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PagamentoDTO {
    private Long id;
    private BigDecimal valor;
    private Date data;
    private String status;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}
