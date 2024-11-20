package br.com.ecommerce.mapper;

import org.mapstruct.Mapper;

import br.com.ecommerce.dto.RoleDTO;
import br.com.ecommerce.model.RoleModel;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    
    RoleDTO toRoleDTO(RoleModel roleModel);
    
    RoleModel toRoleModel(RoleDTO roleDTO);
}
