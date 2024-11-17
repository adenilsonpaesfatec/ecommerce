package br.com.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.ecommerce.dto.CategoriaDTO;
import br.com.ecommerce.model.CategoriaModel;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    
    @Mapping(source = "produtos", target = "produtos")
    CategoriaDTO toCategoriaDTO(CategoriaModel categoriaModel);
    
    @Mapping(source = "produtos", target = "produtos")
    CategoriaModel toCategoriaModel(CategoriaDTO categoriaDTO);
}