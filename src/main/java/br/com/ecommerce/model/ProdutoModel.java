package br.com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Access(AccessType.FIELD)
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prd_id")
    private Long id;

    @Column(name = "prd_nome", nullable = false)
    private String nome;

    @Column(name = "prd_descricao")
    private String descricao;

    @Column(name = "prd_preco", nullable = false)
    private BigDecimal preco;

    @Column(name = "prd_estoque", nullable = false)
    private Integer estoque;

    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    private CategoriaModel categoria;
}
