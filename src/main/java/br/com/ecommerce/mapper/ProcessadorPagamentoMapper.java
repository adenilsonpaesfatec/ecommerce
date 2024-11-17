package br.com.ecommerce.mapper;

import org.mapstruct.Mapper;

import br.com.ecommerce.dto.ProcessadorPagamentoDTO;
import br.com.ecommerce.model.ProcessadorPagamentoModel;

@Mapper(componentModel = "spring")
public interface ProcessadorPagamentoMapper {
    
	ProcessadorPagamentoDTO toProcessadorPagamentoDTO(ProcessadorPagamentoModel processadorPagamentoModel);
    
	ProcessadorPagamentoModel toProcessadorPagamentoModel(ProcessadorPagamentoDTO processadorPagamentoDTO);
}
