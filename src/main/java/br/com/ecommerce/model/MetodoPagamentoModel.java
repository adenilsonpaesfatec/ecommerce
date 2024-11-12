package br.com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "metodos_pagamento")
@Data
@Access(AccessType.FIELD)
public class MetodoPagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mpg_id")
    private Long id;

    @Column(name = "mpg_tipo", nullable = false, unique = true)
    private String tipo;

    @Column(name = "mpg_descricao")
    private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
