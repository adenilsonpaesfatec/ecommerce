package br.com.ecommerce.service;

import br.com.ecommerce.dto.MetodoPagamentoDTO;
import br.com.ecommerce.mapper.MetodoPagamentoMapper;
import br.com.ecommerce.model.MetodoPagamentoModel;
import br.com.ecommerce.repository.MetodoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MetodoPagamentoServiceImpl implements MetodoPagamentoService {

    @Autowired
    private MetodoPagamentoRepository metodoPagamentoRepository;
    
    @Autowired
    private MetodoPagamentoMapper metodoPagamentoMapper;

    @Override
    public MetodoPagamentoDTO salvar(MetodoPagamentoDTO metodoPagamentoDTO) {
        MetodoPagamentoModel metodoPagamentoModel = metodoPagamentoMapper
        		.toMetodoPagamentoModel(metodoPagamentoDTO);
        MetodoPagamentoModel savedMetodo = metodoPagamentoRepository
        		.save(metodoPagamentoModel);
        return metodoPagamentoMapper
        		.toMetodoPagamentoDTO(savedMetodo);
    }

    @Override
    public Optional<MetodoPagamentoDTO> buscarPorId(Long id) {
        return metodoPagamentoRepository
        		.findById(id)
        		.map(metodoPagamentoMapper::toMetodoPagamentoDTO);
    }

    @Override
    public List<MetodoPagamentoDTO> listarTodos() {
        return metodoPagamentoRepository
        		.findAll()
        		.stream()
        		.map(metodoPagamentoMapper::toMetodoPagamentoDTO)
        		.collect(Collectors
        				.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        metodoPagamentoRepository
        .deleteById(id);
    }

}
