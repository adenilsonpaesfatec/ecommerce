package br.com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "metodos_pagamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}