package br.com.ecommerce.service;

import br.com.ecommerce.dto.ClienteDTO;
import br.com.ecommerce.mapper.ClienteMapper;
import br.com.ecommerce.model.ClienteModel;
import br.com.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        ClienteModel clienteModel = clienteMapper.toClienteModel(clienteDTO);
        ClienteModel savedCliente = clienteRepository.save(clienteModel);
        return clienteMapper.toClienteDTO(savedCliente);
    }

    @Override
    public Optional<ClienteDTO> buscarPorId(Long id) {
        return clienteRepository.findById(id).map(clienteMapper::toClienteDTO);
    }

    @Override
    public List<ClienteDTO> listarTodos() {
        return clienteRepository.findAll().stream()
        		.map(clienteMapper::toClienteDTO)
        		.collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        clienteRepository.deleteById(id);
    }
}
