package br.com.ecommerce.controller;

import br.com.ecommerce.dto.UsuarioDTO;
import br.com.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Validated
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodos() {
        List<UsuarioDTO> usuarios = usuarioService
        		.listarTodos();
        return ResponseEntity
        		.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        return usuarioService
        		.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Usuário não encontrado"));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO novoUsuario = usuarioService
        		.salvar(usuarioDTO);
        return ResponseEntity
        		.status(HttpStatus
        				.CREATED)
        		.body(novoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        usuarioService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Usuário não encontrado"));

        usuarioDTO.setId(id);
        UsuarioDTO usuarioAtualizado = usuarioService
        		.salvar(usuarioDTO);
        return ResponseEntity
        		.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Usuário não encontrado"));

        usuarioService
        .deletarPorId(id);
        return ResponseEntity
        		.noContent()
        		.build();
    }
}
