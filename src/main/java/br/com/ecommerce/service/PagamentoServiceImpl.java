package br.com.ecommerce.service;

import br.com.ecommerce.dto.PagamentoDTO;
import br.com.ecommerce.mapper.PagamentoMapper;
import br.com.ecommerce.model.PagamentoModel;
import br.com.ecommerce.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;
    
    @Autowired
    private PagamentoMapper pagamentoMapper;

    @Override
    public PagamentoDTO salvar(PagamentoDTO pagamentoDTO) {
        PagamentoModel pagamentoModel = pagamentoMapper
        		.toPagamentoModel(pagamentoDTO);
        PagamentoModel savedPagamento = pagamentoRepository
        		.save(pagamentoModel);
        return pagamentoMapper
        		.toPagamentoDTO(savedPagamento);
    }

    @Override
    public Optional<PagamentoDTO> buscarPorId(Long id) {
        return pagamentoRepository
        		.findById(id)
        		.map(pagamentoMapper::toPagamentoDTO);
    }

    @Override
    public List<PagamentoDTO> listarTodos() {
        return pagamentoRepository
        		.findAll()
        		.stream()
        		.map(pagamentoMapper::toPagamentoDTO)
        		.collect(Collectors
        				.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        pagamentoRepository
        .deleteById(id);
    }
}
