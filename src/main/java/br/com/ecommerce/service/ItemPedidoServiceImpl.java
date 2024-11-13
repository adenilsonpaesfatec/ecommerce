package br.com.ecommerce.service;

import br.com.ecommerce.dto.ItemPedidoDTO;
import br.com.ecommerce.mapper.ItemPedidoMapper;
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
    
    @Autowired
    private ItemPedidoMapper itemPedidoMapper;

    @Override
    public ItemPedidoDTO salvar(ItemPedidoDTO itemPedidoDTO) {
        ItemPedidoModel itemPedidoModel = itemPedidoMapper
        		.toItemPedidoModel(itemPedidoDTO);
        ItemPedidoModel savedItemPedido = itemPedidoRepository
        		.save(itemPedidoModel);
        return itemPedidoMapper
        		.toItemPedidoDTO(savedItemPedido);
    }

    @Override
    public Optional<ItemPedidoDTO> buscarPorId(Long id) {
        return itemPedidoRepository
        		.findById(id)
        		.map(itemPedidoMapper::toItemPedidoDTO);
    }

    @Override
    public List<ItemPedidoDTO> listarTodos() {
        return itemPedidoRepository
        		.findAll()
        		.stream()
        		.map(itemPedidoMapper::toItemPedidoDTO)
        		.collect(Collectors
        				.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        itemPedidoRepository
        .deleteById(id);
    }

}
