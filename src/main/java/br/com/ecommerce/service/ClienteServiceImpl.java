package br.com.ecommerce.service;

import br.com.ecommerce.dto.ClienteDTO;
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

    @Override
    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        ClienteModel clienteModel = toClienteModel(clienteDTO);
        ClienteModel savedCliente = clienteRepository.save(clienteModel);
        return toClienteDTO(savedCliente);
    }

    @Override
    public Optional<ClienteDTO> buscarPorId(Long id) {
        return clienteRepository.findById(id).map(this::toClienteDTO);
    }

    @Override
    public List<ClienteDTO> listarTodos() {
        return clienteRepository.findAll().stream().map(this::toClienteDTO).collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        clienteRepository.deleteById(id);
    }

    private ClienteDTO toClienteDTO(ClienteModel cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setTelefone(cliente.getTelefone());
        // Conversão de usuário para DTO
        return dto;
    }

    private ClienteModel toClienteModel(ClienteDTO dto) {
        ClienteModel cliente = new ClienteModel();
        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());
        // Conversão do usuário do DTO para o modelo, se necessário
        return cliente;
    }
}
