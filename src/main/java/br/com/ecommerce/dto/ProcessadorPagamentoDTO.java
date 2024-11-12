package br.com.ecommerce.dto;

import lombok.Data;

@Data
public class ProcessadorPagamentoDTO {
    private Long id;
    private String nome;
    private String configuracoes;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getConfiguracoes() {
		return configuracoes;
	}
	public void setConfiguracoes(String configuracoes) {
		this.configuracoes = configuracoes;
	}
    
}
