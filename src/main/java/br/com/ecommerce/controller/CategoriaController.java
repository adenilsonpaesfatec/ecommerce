package br.com.ecommerce.controller;

import br.com.ecommerce.dto.CategoriaDTO;
import br.com.ecommerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@Validated
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarTodos() {
        List<CategoriaDTO> categorias = categoriaService
        		.listarTodos();
        return ResponseEntity
        		.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id) {
        return categoriaService
        		.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Categoria não encontrada"));
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> criar(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO novaCategoria = categoriaService
        		.salvar(categoriaDTO);
        return ResponseEntity
        		.status(HttpStatus
        				.CREATED)
        		.body(novaCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaDTO categoriaDTO) {
        categoriaService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Categoria não encontrada"));
        categoriaDTO.setId(id);
        CategoriaDTO categoriaAtualizada = categoriaService
        		.salvar(categoriaDTO);
        return ResponseEntity
        		.ok(categoriaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Categoria não encontrada"));
        categoriaService.deletarPorId(id);
        return ResponseEntity
        		.noContent()
        		.build();
    }
}
