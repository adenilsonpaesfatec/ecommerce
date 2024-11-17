package br.com.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.ecommerce.dto.PedidoDTO;
import br.com.ecommerce.model.PedidoModel;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    
    @Mapping(source = "cliente", target = "cliente")
    @Mapping(source = "itens", target = "itens")
    PedidoDTO toPedidoDTO(PedidoModel PedidoModel);
    
    @Mapping(source = "cliente", target = "cliente")
    @Mapping(source = "itens", target = "itens")
    PedidoModel toPedidoModel(PedidoDTO PedidoDTO);
}
