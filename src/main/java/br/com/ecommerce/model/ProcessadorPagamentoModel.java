package br.com.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "processadores_pagamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
public class ProcessadorPagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ppg_id")
    private Long id;

    @NotNull(message = "O campo 'nome' é obrigatório")
    @Size(min = 2, max = 50, message = "O campo 'nome' deve ter entre 2 e 50 caracteres")
    @Column(name = "ppg_nome", nullable = false)
    private String nome;

    @Size(max = 255, message = "O campo 'configuracoes' pode ter no máximo 255 caracteres")
    @Column(name = "ppg_configuracoes")
    private String configuracoes;
}
