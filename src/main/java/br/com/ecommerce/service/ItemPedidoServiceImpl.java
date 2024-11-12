package br.com.ecommerce.service;

import br.com.ecommerce.dto.ItemPedidoDTO;
import br.com.ecommerce.model.ItemPedidoModel;
import br.com.ecommerce.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Override
    public ItemPedidoDTO salvar(ItemPedidoDTO itemPedidoDTO) {
        ItemPedidoModel itemPedidoModel = toItemPedidoModel(itemPedidoDTO);
        ItemPedidoModel savedItemPedido = itemPedidoRepository.save(itemPedidoModel);
        return toItemPedidoDTO(savedItemPedido);
    }

    @Override
    public Optional<ItemPedidoDTO> buscarPorId(Long id) {
        return itemPedidoRepository.findById(id).map(this::toItemPedidoDTO);
    }

    @Override
    public List<ItemPedidoDTO> listarTodos() {
        return itemPedidoRepository.findAll().stream().map(this::toItemPedidoDTO).collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        itemPedidoRepository.deleteById(id);
    }

    private ItemPedidoDTO toItemPedidoDTO(ItemPedidoModel item) {
        ItemPedidoDTO dto = new ItemPedidoDTO();
        dto.setId(item.getId());
        dto.setQuantidade(item.getQuantidade());
        dto.setPreco(item.getPreco());
        // Mapear o produto, se necessário
        return dto;
    }

    private ItemPedidoModel toItemPedidoModel(ItemPedidoDTO dto) {
        ItemPedidoModel item = new ItemPedidoModel();
        item.setId(dto.getId());
        item.setQuantidade(dto.getQuantidade());
        item.setPreco(dto.getPreco());
        // Mapear o produto, se necessário
        return item;
    }
}
