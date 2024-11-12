package br.com.ecommerce.service;

import br.com.ecommerce.dto.PagamentoDTO;
import java.util.List;
import java.util.Optional;

public interface PagamentoService {
    PagamentoDTO salvar(PagamentoDTO pagamentoDTO);
    Optional<PagamentoDTO> buscarPorId(Long id);
    List<PagamentoDTO> listarTodos();
    void deletarPorId(Long id);
}
