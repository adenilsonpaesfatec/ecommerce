package br.com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "processadores_pagamento")
@Data
@Access(AccessType.FIELD)
public class ProcessadorPagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ppg_id")
    private Long id;

    @Column(name = "ppg_nome", nullable = false)
    private String nome;

    @Column(name = "ppg_configuracoes")
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
