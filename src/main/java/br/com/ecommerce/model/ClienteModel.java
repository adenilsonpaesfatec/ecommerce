package br.com.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private Long id;

    @Column(name = "cli_nome", nullable = false)
    @NotNull(message = "O campo 'nome' é obrigatório")
    @Size(min = 2, max = 100, message = "O campo 'nome' deve ter entre 2 e 100 caracteres")
    private String nome;

    @Column(name = "cli_telefone")
    @Size(max = 20, message = "O campo 'telefone' pode ter no máximo 20 caracteres")
    private String telefone;

    @OneToOne
    @JoinColumn(name = "usr_id", nullable = false)
    private UsuarioModel usuario;

}
