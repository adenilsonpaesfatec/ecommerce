package br.com.ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

import br.com.ecommerce.model.MetodoPagamentoModel;
import br.com.ecommerce.model.PedidoModel;
import br.com.ecommerce.model.ProcessadorPagamentoModel;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {

    private Long id;

    @NotNull(message = "O campo 'valor' é obrigatório")
    private BigDecimal valor;

    @NotNull(message = "O campo 'data' é obrigatório")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @NotNull(message = "O campo 'status' é obrigatório")
    private String status;

    @NotNull(message = "O campo 'pedido' é obrigatório")
    private PedidoModel pedido;

    @NotNull(message = "O campo 'metodoPagamento' é obrigatório")
    private MetodoPagamentoModel metodoPagamento;

    @NotNull(message = "O campo 'processadorPagamento' é obrigatório")
    private ProcessadorPagamentoModel processadorPagamento;
    
}
