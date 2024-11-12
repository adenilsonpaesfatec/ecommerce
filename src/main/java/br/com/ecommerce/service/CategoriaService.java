package br.com.ecommerce.service;

import br.com.ecommerce.dto.CategoriaDTO;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    CategoriaDTO salvar(CategoriaDTO categoriaDTO);
    Optional<CategoriaDTO> buscarPorId(Long id);
    List<CategoriaDTO> listarTodos();
    void deletarPorId(Long id);
}
