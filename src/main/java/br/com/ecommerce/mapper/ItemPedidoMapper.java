package br.com.ecommerce.mapper;

import br.com.ecommerce.dto.ItemPedidoDTO;
import br.com.ecommerce.model.ItemPedidoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {
    
    @Mapping(source = "pedido", target = "pedido")
    @Mapping(source = "produto", target = "produto")
    ItemPedidoDTO toItemPedidoDTO(ItemPedidoModel itemPedidoModel);
    
    @Mapping(source = "pedido", target = "pedido")
    @Mapping(source = "produto", target = "produto")
    ItemPedidoModel toItemPedidoModel(ItemPedidoDTO itemPedidoDTO);
    
}
