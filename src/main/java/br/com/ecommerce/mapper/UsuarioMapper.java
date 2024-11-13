package br.com.ecommerce.mapper;

import br.com.ecommerce.dto.UsuarioDTO;
import br.com.ecommerce.model.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    
    @Mapping(source = "role", target = "role") // Mapeia o campo role usando a relação
    UsuarioDTO toUsuarioDTO(UsuarioModel usuarioModel);
    
    @Mapping(source = "role", target = "role") // Mapeia o campo role usando a relação
    UsuarioModel toUsuarioModel(UsuarioDTO usuarioDTO);
}
