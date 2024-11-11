package br.com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Access(AccessType.FIELD)
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private Long id;

    @Column(name = "cli_nome", nullable = false)
    private String nome;

    @Column(name = "cli_telefone")
    private String telefone;

    @OneToOne
    @JoinColumn(name = "usr_id", nullable = false)
    private UsuarioModel usuario;
}
