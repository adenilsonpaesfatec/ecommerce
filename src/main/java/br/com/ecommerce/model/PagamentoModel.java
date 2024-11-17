package br.com.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pagamentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
public class PagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pag_id")
    private Long id;

    @NotNull(message = "O campo 'valor' é obrigatório")
    @Column(name = "pag_valor", nullable = false)
    private BigDecimal valor;

    @NotNull(message = "O campo 'data' é obrigatório")
    @Column(name = "pag_data", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @NotNull(message = "O campo 'status' é obrigatório")
    @Column(name = "pag_status", nullable = false)
    private String status;

    @NotNull(message = "O campo 'pedido' é obrigatório")
    @OneToOne
    @JoinColumn(name = "ped_id", nullable = false)
    private PedidoModel pedido;

    @NotNull(message = "O campo 'metodoPagamento' é obrigatório")
    @ManyToOne
    @JoinColumn(name = "mpg_id", nullable = false)
    private MetodoPagamentoModel metodoPagamento;

    @NotNull(message = "O campo 'processadorPagamento' é obrigatório")
    @ManyToOne
    @JoinColumn(name = "ppg_id", nullable = false)
    private ProcessadorPagamentoModel processadorPagamento;
    
}
