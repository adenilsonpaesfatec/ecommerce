package br.com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "processadores_pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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
}
