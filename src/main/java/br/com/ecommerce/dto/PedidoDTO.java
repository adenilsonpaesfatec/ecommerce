package br.com.ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;
import java.util.List;

import br.com.ecommerce.model.ClienteModel;
import br.com.ecommerce.model.ItemPedidoModel;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long id;

    @NotNull(message = "O campo 'data' é obrigatório")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @NotNull(message = "O campo 'status' é obrigatório")
    @Size(min = 3, max = 20, message = "O campo 'status' deve ter entre 3 e 20 caracteres")
    private String status;

    @NotNull(message = "O campo 'cliente' é obrigatório")
    private ClienteModel cliente;

    @NotNull(message = "A lista de 'itens' não pode estar vazia")
    private List<ItemPedidoModel> itens;
    
}
