package br.com.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.*;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prd_id")
    private Long id;

    @NotNull(message = "O campo 'nome' é obrigatório")
    @Size(min = 2, max = 100, message = "O campo 'nome' deve ter entre 2 e 100 caracteres")
    @Column(name = "prd_nome", nullable = false)
    private String nome;

    @Size(max = 255, message = "O campo 'descricao' pode ter no máximo 255 caracteres")
    @Column(name = "prd_descricao")
    private String descricao;

    @NotNull(message = "O campo 'preco' é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O campo 'preco' deve ser maior que zero")
    @Column(name = "prd_preco", nullable = false)
    private BigDecimal preco;

    @NotNull(message = "O campo 'estoque' é obrigatório")
    @Min(value = 0, message = "O campo 'estoque' deve ser zero ou maior")
    @Column(name = "prd_estoque", nullable = false)
    private Integer estoque;

    @NotNull(message = "O campo 'categoria' é obrigatório")
    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    @JsonIgnore
    private CategoriaModel categoria;

}
