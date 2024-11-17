package br.com.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "O campo 'tipo' é obrigatório")
    @Size(min = 2, max = 100, message = "O campo 'tipo' deve ter entre 2 e 100 caracteres")
    @Column(name = "mpg_tipo", nullable = false, unique = true)
    private String tipo;

    @Size(max = 255, message = "O campo 'descricao' pode ter no máximo 255 caracteres")
    @Column(name = "mpg_descricao")
    private String descricao;
}
