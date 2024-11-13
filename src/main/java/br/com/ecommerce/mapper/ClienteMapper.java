package br.com.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.ecommerce.dto.ClienteDTO;
import br.com.ecommerce.model.ClienteModel;


@Mapper(componentModel = "spring")
public interface ClienteMapper {
    
    @Mapping(source = "usuario", target = "usuario") // Mapeia o campo role usando a relação
    ClienteDTO toClienteDTO(ClienteModel clienteModel);
    
    @Mapping(source = "usuario", target = "usuario") // Mapeia o campo role usando a relação
    ClienteModel toClienteModel(ClienteDTO clienteDTO);
}