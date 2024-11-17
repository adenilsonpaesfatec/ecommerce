package br.com.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.ecommerce.dto.EnderecoDTO;
import br.com.ecommerce.model.EnderecoModel;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    
    @Mapping(source = "cliente", target = "cliente")
    EnderecoDTO toEnderecoDTO(EnderecoModel enderecoModel);
    
    @Mapping(source = "cliente", target = "cliente")
    EnderecoModel toEnderecoModel(EnderecoDTO enderecoDTO);
}
