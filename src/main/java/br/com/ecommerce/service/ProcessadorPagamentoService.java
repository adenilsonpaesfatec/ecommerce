package br.com.ecommerce.service;

import br.com.ecommerce.dto.ProcessadorPagamentoDTO;
import java.util.List;
import java.util.Optional;

public interface ProcessadorPagamentoService {
    ProcessadorPagamentoDTO salvar(ProcessadorPagamentoDTO processadorPagamentoDTO);
    Optional<ProcessadorPagamentoDTO> buscarPorId(Long id);
    List<ProcessadorPagamentoDTO> listarTodos();
    void deletarPorId(Long id);
}
