package br.com.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_id")
    private Long id;

    @NotNull(message = "O campo 'data' é obrigatório")
    @Column(name = "ped_data", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @NotNull(message = "O campo 'status' é obrigatório")
    @Size(min = 3, max = 20, message = "O campo 'status' deve ter entre 3 e 20 caracteres")
    @Column(name = "ped_status", nullable = false)
    private String status;

    @NotNull(message = "O campo 'cliente' é obrigatório")
    @ManyToOne
    @JoinColumn(name = "cli_id", nullable = false)
    private ClienteModel cliente;

    @NotNull(message = "A lista de 'itens' não pode estar vazia")
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedidoModel> itens;
    
}
