package br.com.ecommerce.service;

import br.com.ecommerce.dto.PedidoDTO;
import br.com.ecommerce.dto.ItemPedidoDTO;
import br.com.ecommerce.model.PedidoModel;
import br.com.ecommerce.model.ItemPedidoModel;
import br.com.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public PedidoDTO salvar(PedidoDTO pedidoDTO) {
        PedidoModel pedidoModel = toPedidoModel(pedidoDTO);
        PedidoModel savedPedido = pedidoRepository.save(pedidoModel);
        return toPedidoDTO(savedPedido);
    }

    @Override
    public Optional<PedidoDTO> buscarPorId(Long id) {
        return pedidoRepository.findById(id).map(this::toPedidoDTO);
    }

    @Override
    public List<PedidoDTO> listarTodos() {
        return pedidoRepository.findAll().stream().map(this::toPedidoDTO).collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        pedidoRepository.deleteById(id);
    }

    private PedidoDTO toPedidoDTO(PedidoModel pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setData(pedido.getData());
        dto.setStatus(pedido.getStatus());
        dto.setItens(pedido.getItens().stream().map(this::toItemPedidoDTO).collect(Collectors.toList()));
        // Conversão do cliente, se necessário
        return dto;
    }

    private ItemPedidoDTO toItemPedidoDTO(ItemPedidoModel item) {
        ItemPedidoDTO dto = new ItemPedidoDTO();
        dto.setId(item.getId());
        dto.setQuantidade(item.getQuantidade());
        dto.setPreco(item.getPreco());
        // Conversão do produto, se necessário
        return dto;
    }

    private PedidoModel toPedidoModel(PedidoDTO dto) {
        PedidoModel pedido = new PedidoModel();
        pedido.setId(dto.getId());
        pedido.setData(dto.getData());
        pedido.setStatus(dto.getStatus());
        // Adicionar conversão de cliente e itens, se necessário
        return pedido;
    }
}
