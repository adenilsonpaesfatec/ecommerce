package br.com.ecommerce.service;

import br.com.ecommerce.dto.ProcessadorPagamentoDTO;
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

    @Override
    public ProcessadorPagamentoDTO salvar(ProcessadorPagamentoDTO processadorPagamentoDTO) {
        ProcessadorPagamentoModel processadorPagamentoModel = toProcessadorPagamentoModel(processadorPagamentoDTO);
        ProcessadorPagamentoModel savedProcessador = processadorPagamentoRepository.save(processadorPagamentoModel);
        return toProcessadorPagamentoDTO(savedProcessador);
    }

    @Override
    public Optional<ProcessadorPagamentoDTO> buscarPorId(Long id) {
        return processadorPagamentoRepository.findById(id).map(this::toProcessadorPagamentoDTO);
    }

    @Override
    public List<ProcessadorPagamentoDTO> listarTodos() {
        return processadorPagamentoRepository.findAll().stream().map(this::toProcessadorPagamentoDTO).collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        processadorPagamentoRepository.deleteById(id);
    }

    private ProcessadorPagamentoDTO toProcessadorPagamentoDTO(ProcessadorPagamentoModel processador) {
        ProcessadorPagamentoDTO dto = new ProcessadorPagamentoDTO();
        dto.setId(processador.getId());
        dto.setNome(processador.getNome());
        dto.setConfiguracoes(processador.getConfiguracoes());
        return dto;
    }

    private ProcessadorPagamentoModel toProcessadorPagamentoModel(ProcessadorPagamentoDTO dto) {
        ProcessadorPagamentoModel processador = new ProcessadorPagamentoModel();
        processador.setId(dto.getId());
        processador.setNome(dto.getNome());
        processador.setConfiguracoes(dto.getConfiguracoes());
        return processador;
    }
}
