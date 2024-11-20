package br.com.ecommerce.controller;

import br.com.ecommerce.dto.EnderecoDTO;
import br.com.ecommerce.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
@Validated
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listarTodos() {
        List<EnderecoDTO> enderecos = enderecoService
        		.listarTodos();
        return ResponseEntity
        		.ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> buscarPorId(@PathVariable Long id) {
        return enderecoService
        		.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Endereço não encontrado"));
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> criar(@Valid @RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO novoEndereco = enderecoService
        		.salvar(enderecoDTO);
        return ResponseEntity
        		.status(HttpStatus
        				.CREATED)
        		.body(novoEndereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody EnderecoDTO enderecoDTO) {
        enderecoService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Endereço não encontrado"));
        enderecoDTO.setId(id);
        EnderecoDTO enderecoAtualizado = enderecoService
        		.salvar(enderecoDTO);
        return ResponseEntity
        		.ok(enderecoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        enderecoService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Endereço não encontrado"));
        enderecoService.deletarPorId(id);
        return ResponseEntity
        		.noContent()
        		.build();
    }
}
