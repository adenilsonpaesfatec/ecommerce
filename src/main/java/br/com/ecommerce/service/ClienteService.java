package br.com.ecommerce.service;

import br.com.ecommerce.dto.ClienteDTO;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    ClienteDTO salvar(ClienteDTO clienteDTO);
    Optional<ClienteDTO> buscarPorId(Long id);
    List<ClienteDTO> listarTodos();
    void deletarPorId(Long id);
}
