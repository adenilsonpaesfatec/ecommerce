package br.com.ecommerce.service;

import br.com.ecommerce.dto.PedidoDTO;
import java.util.List;
import java.util.Optional;

public interface PedidoService {
    PedidoDTO salvar(PedidoDTO pedidoDTO);
    Optional<PedidoDTO> buscarPorId(Long id);
    List<PedidoDTO> listarTodos();
    void deletarPorId(Long id);
}
