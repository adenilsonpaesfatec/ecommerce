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

    @Column(name = "rol_nome", nullable = false, unique = true)
    @NotNull(message = "O campo 'nome' é obrigatório")
    private String nome;

}
