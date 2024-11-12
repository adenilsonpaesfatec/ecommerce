package br.com.ecommerce.service;

import br.com.ecommerce.dto.ProdutoDTO;
import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    ProdutoDTO salvar(ProdutoDTO produtoDTO);
    Optional<ProdutoDTO> buscarPorId(Long id);
    List<ProdutoDTO> listarTodos();
    void deletarPorId(Long id);
}
