package br.com.ecommerce.service;

import br.com.ecommerce.dto.EnderecoDTO;
import java.util.List;
import java.util.Optional;

public interface EnderecoService {
    EnderecoDTO salvar(EnderecoDTO enderecoDTO);
    Optional<EnderecoDTO> buscarPorId(Long id);
    List<EnderecoDTO> listarTodos();
    void deletarPorId(Long id);
}
