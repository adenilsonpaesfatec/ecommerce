package br.com.ecommerce.mapper;

import org.mapstruct.Mapper;
import br.com.ecommerce.dto.MetodoPagamentoDTO;
import br.com.ecommerce.model.MetodoPagamentoModel;

@Mapper(componentModel = "spring")
public interface MetodoPagamentoMapper {
    
    MetodoPagamentoDTO toMetodoPagamentoDTO(MetodoPagamentoModel metodoPagamentoModel);
    
    MetodoPagamentoModel toMetodoPagamentoModel(MetodoPagamentoDTO metodoPagamentoDTO);
}
