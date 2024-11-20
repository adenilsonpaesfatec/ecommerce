package br.com.ecommerce.controller;

import br.com.ecommerce.dto.RoleDTO;
import br.com.ecommerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
@Validated
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleDTO>> listarTodos() {
        List<RoleDTO> roles = roleService
        		.listarTodos();
        return ResponseEntity
        		.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> buscarPorId(@PathVariable Long id) {
        return roleService
        		.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Role não encontrada"));
    }

    @PostMapping
    public ResponseEntity<RoleDTO> criar(@Valid @RequestBody RoleDTO roleDTO) {
        RoleDTO novaRole = roleService
        		.salvar(roleDTO);
        return ResponseEntity
        		.status(HttpStatus
        				.CREATED).body(novaRole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> atualizar(@PathVariable Long id, @Valid @RequestBody RoleDTO roleDTO) {
        roleService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Role não encontrada"));
        roleDTO
        .setId(id);
        RoleDTO roleAtualizada = roleService
        		.salvar(roleDTO);
        return ResponseEntity
        		.ok(roleAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        roleService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Role não encontrada"));
        roleService
        .deletarPorId(id);
        return ResponseEntity
        		.noContent()
        		.build();
    }
}
