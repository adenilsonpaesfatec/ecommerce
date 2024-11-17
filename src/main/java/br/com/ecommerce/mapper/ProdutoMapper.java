package br.com.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.ecommerce.dto.ProdutoDTO;
import br.com.ecommerce.model.ProdutoModel;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    
    @Mapping(source = "categoria", target = "categoria")
    ProdutoDTO toProdutoDTO(ProdutoModel produtoModel);
    
    @Mapping(source = "categoria", target = "categoria")
    ProdutoModel toProdutoModel(ProdutoDTO prodtoDTO);
}
