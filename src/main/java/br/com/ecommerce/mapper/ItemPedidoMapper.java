package br.com.ecommerce.mapper;

import br.com.ecommerce.dto.ItemPedidoDTO;
import br.com.ecommerce.model.ItemPedidoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {
    
    @Mapping(source = "pedido", target = "pedido") // Mapeia o campo role usando a relação
    @Mapping(source = "produto", target = "produto") // Mapeia o campo role usando a relação
    ItemPedidoDTO toItemPedidoDTO(ItemPedidoModel ItemPedidoModel);
    
    @Mapping(source = "pedido", target = "pedido") // Mapeia o campo role usando a relação
    @Mapping(source = "produto", target = "produto") // Mapeia o campo role usando a relação
    ItemPedidoModel toItemPedidoModel(ItemPedidoDTO ItemPedidoDTO);
    
}
