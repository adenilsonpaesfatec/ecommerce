package br.com.ecommerce.model;

import jakarta.persistence.*;
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

    @Column(name = "cat_nome", nullable = false)
    private String nome;

    @Column(name = "cat_descricao")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<ProdutoModel> produtos;

}
