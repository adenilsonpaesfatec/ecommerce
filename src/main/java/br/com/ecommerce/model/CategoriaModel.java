package br.com.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Long id;

    @NotNull(message = "O campo 'nome' é obrigatório")
    @Size(min = 2, max = 100, message = "O campo 'nome' deve ter entre 2 e 100 caracteres")
    @Column(name = "cat_nome", nullable = false)
    private String nome;

    @Size(max = 255, message = "O campo 'descricao' pode ter no máximo 255 caracteres")
    @Column(name = "cat_descricao")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<ProdutoModel> produtos;

}
