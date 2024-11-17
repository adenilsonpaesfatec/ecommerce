package br.com.ecommerce.service;

import br.com.ecommerce.dto.ProcessadorPagamentoDTO;
import br.com.ecommerce.mapper.ProcessadorPagamentoMapper;
import br.com.ecommerce.model.ProcessadorPagamentoModel;
import br.com.ecommerce.repository.ProcessadorPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcessadorPagamentoServiceImpl implements ProcessadorPagamentoService {

    @Autowired
    private ProcessadorPagamentoRepository processadorPagamentoRepository;
    
    @Autowired
    private ProcessadorPagamentoMapper processadorPagamentoMapper;

    @Override
    public ProcessadorPagamentoDTO salvar(ProcessadorPagamentoDTO processadorPagamentoDTO) {
        ProcessadorPagamentoModel processadorPagamentoModel = processadorPagamentoMapper
        		.toProcessadorPagamentoModel(processadorPagamentoDTO);
        ProcessadorPagamentoModel savedProcessador = processadorPagamentoRepository
        		.save(processadorPagamentoModel);
        return processadorPagamentoMapper
        		.toProcessadorPagamentoDTO(savedProcessador);
    }

    @Override
    public Optional<ProcessadorPagamentoDTO> buscarPorId(Long id) {
        return processadorPagamentoRepository
        		.findById(id)
        		.map(processadorPagamentoMapper::toProcessadorPagamentoDTO);
    }

    @Override
    public List<ProcessadorPagamentoDTO> listarTodos() {
        return processadorPagamentoRepository
        		.findAll()
        		.stream()
        		.map(processadorPagamentoMapper::toProcessadorPagamentoDTO)
        		.collect(Collectors
        				.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        processadorPagamentoRepository
        .deleteById(id);
    }

}
