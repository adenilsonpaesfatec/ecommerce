package br.com.ecommerce.service;

import br.com.ecommerce.dto.ItemPedidoDTO;
import java.util.List;
import java.util.Optional;

public interface ItemPedidoService {
    ItemPedidoDTO salvar(ItemPedidoDTO itemPedidoDTO);
    Optional<ItemPedidoDTO> buscarPorId(Long id);
    List<ItemPedidoDTO> listarTodos();
    void deletarPorId(Long id);
}
