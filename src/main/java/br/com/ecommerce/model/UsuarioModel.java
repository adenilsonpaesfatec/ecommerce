package br.com.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    @Column(name = "usr_email", nullable = false, unique = true)
    @NotNull(message = "O campo 'email' é obrigatório")
    @Email(message = "O campo 'email' deve conter um endereço de e-mail válido")
    @Size(max = 100, message = "O campo 'email' pode ter no máximo 100 caracteres")
    private String email;

    @Column(name = "usr_senha", nullable = false)
    @NotNull(message = "O campo 'senha' é obrigatório")
    @Size(min = 6, max = 20, message = "O campo 'senha' deve ter entre 6 e 20 caracteres")
    private String senha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id", nullable = false)
    private RoleModel role;

}
