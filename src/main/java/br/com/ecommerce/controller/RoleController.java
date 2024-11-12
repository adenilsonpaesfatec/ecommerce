package br.com.ecommerce.controller;

import br.com.ecommerce.dto.RoleDTO;
import br.com.ecommerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleDTO>> listarTodos() {
        List<RoleDTO> roles = roleService.listarTodos();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> buscarPorId(@PathVariable Long id) {
        Optional<RoleDTO> role = roleService.buscarPorId(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RoleDTO> criar(@RequestBody RoleDTO roleDTO) {
        RoleDTO novaRole = roleService.salvar(roleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaRole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> atualizar(@PathVariable Long id, @RequestBody RoleDTO roleDTO) {
        if (!roleService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        roleDTO.setId(id);
        RoleDTO roleAtualizada = roleService.salvar(roleDTO);
        return ResponseEntity.ok(roleAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!roleService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        roleService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
