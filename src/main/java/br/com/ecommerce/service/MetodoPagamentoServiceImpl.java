package br.com.ecommerce.service;

import br.com.ecommerce.dto.MetodoPagamentoDTO;
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

    @Override
    public MetodoPagamentoDTO salvar(MetodoPagamentoDTO metodoPagamentoDTO) {
        MetodoPagamentoModel metodoPagamentoModel = toMetodoPagamentoModel(metodoPagamentoDTO);
        MetodoPagamentoModel savedMetodo = metodoPagamentoRepository.save(metodoPagamentoModel);
        return toMetodoPagamentoDTO(savedMetodo);
    }

    @Override
    public Optional<MetodoPagamentoDTO> buscarPorId(Long id) {
        return metodoPagamentoRepository.findById(id).map(this::toMetodoPagamentoDTO);
    }

    @Override
    public List<MetodoPagamentoDTO> listarTodos() {
        return metodoPagamentoRepository.findAll().stream().map(this::toMetodoPagamentoDTO).collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        metodoPagamentoRepository.deleteById(id);
    }

    private MetodoPagamentoDTO toMetodoPagamentoDTO(MetodoPagamentoModel metodo) {
        MetodoPagamentoDTO dto = new MetodoPagamentoDTO();
        dto.setId(metodo.getId());
        dto.setTipo(metodo.getTipo());
        dto.setDescricao(metodo.getDescricao());
        return dto;
    }

    private MetodoPagamentoModel toMetodoPagamentoModel(MetodoPagamentoDTO dto) {
        MetodoPagamentoModel metodo = new MetodoPagamentoModel();
        metodo.setId(dto.getId());
        metodo.setTipo(dto.getTipo());
        metodo.setDescricao(dto.getDescricao());
        return metodo;
    }
}
