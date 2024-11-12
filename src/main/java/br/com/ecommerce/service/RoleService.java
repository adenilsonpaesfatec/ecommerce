package br.com.ecommerce.service;

import br.com.ecommerce.dto.RoleDTO;
import java.util.List;
import java.util.Optional;

public interface RoleService {
    RoleDTO salvar(RoleDTO roleDTO);
    Optional<RoleDTO> buscarPorId(Long id);
    List<RoleDTO> listarTodos();
    void deletarPorId(Long id);
}
