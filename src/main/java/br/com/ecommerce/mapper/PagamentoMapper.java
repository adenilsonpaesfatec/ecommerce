package br.com.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.ecommerce.dto.PagamentoDTO;
import br.com.ecommerce.model.PagamentoModel;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {
    
    @Mapping(source = "pedido", target = "pedido")
    @Mapping(source = "metodoPagamento", target = "metodoPagamento")
    @Mapping(source = "processadorPagamento", target = "processadorPagamento")
    PagamentoDTO toPagamentoDTO(PagamentoModel pagamentoModel);
    
    @Mapping(source = "pedido", target = "pedido")
    @Mapping(source = "metodoPagamento", target = "metodoPagamento")
    @Mapping(source = "processadorPagamento", target = "processadorPagamento")
    PagamentoModel toPagamentoModel(PagamentoDTO pagamentoDTO);
}
