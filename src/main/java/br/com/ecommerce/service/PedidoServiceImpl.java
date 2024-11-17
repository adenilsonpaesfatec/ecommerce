package br.com.ecommerce.service;

import br.com.ecommerce.dto.PedidoDTO;
import br.com.ecommerce.mapper.PedidoMapper;
import br.com.ecommerce.model.PedidoModel;
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
    
    @Autowired
    private PedidoMapper pedidoMapper;

    @Override
    public PedidoDTO salvar(PedidoDTO pedidoDTO) {
        PedidoModel pedidoModel = pedidoMapper
        		.toPedidoModel(pedidoDTO);
        PedidoModel savedPedido = pedidoRepository
        		.save(pedidoModel);
        return pedidoMapper
        		.toPedidoDTO(savedPedido);
    }

    @Override
    public Optional<PedidoDTO> buscarPorId(Long id) {
        return pedidoRepository
        		.findById(id)
        		.map(pedidoMapper::toPedidoDTO);
    }

    @Override
    public List<PedidoDTO> listarTodos() {
        return pedidoRepository
        		.findAll()
        		.stream()
        		.map(pedidoMapper::toPedidoDTO)
        		.collect(Collectors
        				.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        pedidoRepository
        .deleteById(id);
    }

}
