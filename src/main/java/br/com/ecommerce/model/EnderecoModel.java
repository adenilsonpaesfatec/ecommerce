package br.com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enderecos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "end_id")
    private Long id;

    @Column(name = "end_logradouro", nullable = false)
    private String logradouro;

    @Column(name = "end_cidade", nullable = false)
    private String cidade;

    @Column(name = "end_estado", nullable = false)
    private String estado;

    @Column(name = "end_cep", nullable = false)
    private String cep;

    @ManyToOne
    @JoinColumn(name = "cli_id", nullable = false)
    private ClienteModel cliente;

}
