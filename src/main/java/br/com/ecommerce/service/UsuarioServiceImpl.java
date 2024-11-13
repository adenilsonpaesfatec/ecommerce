package br.com.ecommerce.service;

import br.com.ecommerce.dto.UsuarioDTO;
import br.com.ecommerce.model.UsuarioModel;
import br.com.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import br.com.ecommerce.mapper.UsuarioMapper;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        UsuarioModel usuarioModel = usuarioMapper.toUsuarioModel(usuarioDTO);
        UsuarioModel savedUsuario = usuarioRepository.save(usuarioModel);
        return usuarioMapper.toUsuarioDTO(savedUsuario);
    }

    @Override
    public Optional<UsuarioDTO> buscarPorId(Long id) {
        return usuarioRepository.findById(id).map(usuarioMapper::toUsuarioDTO);
    }

    @Override
    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toUsuarioDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }
}
