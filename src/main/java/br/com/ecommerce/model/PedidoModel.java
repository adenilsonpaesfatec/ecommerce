package br.com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Access(AccessType.FIELD)
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_id")
    private Long id;

    @Column(name = "ped_data", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(name = "ped_status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "cli_id", nullable = false)
    private ClienteModel cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedidoModel> itens;
}