package br.com.ecommerce.service;

import br.com.ecommerce.dto.UsuarioDTO;
import br.com.ecommerce.model.UsuarioModel;
import br.com.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        UsuarioModel usuarioModel = toUsuarioModel(usuarioDTO);
        UsuarioModel savedUsuario = usuarioRepository.save(usuarioModel);
        return toUsuarioDTO(savedUsuario);
    }

    @Override
    public Optional<UsuarioDTO> buscarPorId(Long id) {
        return usuarioRepository.findById(id).map(this::toUsuarioDTO);
    }

    @Override
    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(this::toUsuarioDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    private UsuarioDTO toUsuarioDTO(UsuarioModel usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setEmail(usuario.getEmail());
        // Mapear outros campos conforme necessário
        return dto;
    }

    private UsuarioModel toUsuarioModel(UsuarioDTO dto) {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setId(dto.getId());
        usuario.setEmail(dto.getEmail());
        // Mapear outros campos conforme necessário
        return usuario;
    }
}
