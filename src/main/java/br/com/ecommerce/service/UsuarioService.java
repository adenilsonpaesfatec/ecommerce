package br.com.ecommerce.service;

import br.com.ecommerce.dto.UsuarioDTO;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    UsuarioDTO salvar(UsuarioDTO usuarioDTO);
    Optional<UsuarioDTO> buscarPorId(Long id);
    List<UsuarioDTO> listarTodos();
    void deletarPorId(Long id);
}
