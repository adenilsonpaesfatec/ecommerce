package br.com.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotNull(message = "O campo 'logradouro' é obrigatório")
    @Size(max = 100, message = "O campo 'logradouro' pode ter no máximo 100 caracteres")
    @Column(name = "end_logradouro", nullable = false)
    private String logradouro;

    @NotNull(message = "O campo 'cidade' é obrigatório")
    @Size(max = 50, message = "O campo 'cidade' pode ter no máximo 50 caracteres")
    @Column(name = "end_cidade", nullable = false)
    private String cidade;

    @NotNull(message = "O campo 'estado' é obrigatório")
    @Size(max = 20, message = "O campo 'estado' pode ter no máximo 20 caracteres")
    @Column(name = "end_estado", nullable = false)
    private String estado;

    @NotNull(message = "O campo 'cep' é obrigatório")
    @Size(max = 10, message = "O campo 'cep' pode ter no máximo 10 caracteres")
    @Column(name = "end_cep", nullable = false)
    private String cep;

    @NotNull(message = "O campo 'cliente' é obrigatório")
    @ManyToOne
    @JoinColumn(name = "cli_id", nullable = false)
    private ClienteModel cliente;
}
