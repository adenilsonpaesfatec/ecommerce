package br.com.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Long id;

    @NotNull(message = "O campo 'nome' é obrigatório")
    @Size(min = 3, max = 50, message = "O campo 'nome' deve ter entre 3 e 50 caracteres")
    @Column(name = "rol_nome", nullable = false, unique = true)
    private String nome;

}
