package br.com.ecommerce.service;

import br.com.ecommerce.dto.MetodoPagamentoDTO;
import java.util.List;
import java.util.Optional;

public interface MetodoPagamentoService {
    MetodoPagamentoDTO salvar(MetodoPagamentoDTO metodoPagamentoDTO);
    Optional<MetodoPagamentoDTO> buscarPorId(Long id);
    List<MetodoPagamentoDTO> listarTodos();
    void deletarPorId(Long id);
}
