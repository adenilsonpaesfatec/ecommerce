package br.com.ecommerce.controller;

import br.com.ecommerce.dto.ClienteDTO;
import br.com.ecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Validated
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodos() {
        List<ClienteDTO> clientes = clienteService
        		.listarTodos();
        return ResponseEntity
        		.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id) {
        return clienteService
        		.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Cliente não encontrado"));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> criar(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO novoCliente = clienteService
        		.salvar(clienteDTO);
        return ResponseEntity
        		.status(HttpStatus
        				.CREATED).body(novoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO) {
        clienteService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Cliente não encontrado"));
        clienteDTO
        .setId(id);
        ClienteDTO clienteAtualizado = clienteService
        		.salvar(clienteDTO);
        return ResponseEntity
        		.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Cliente não encontrado"));
        clienteService.deletarPorId(id);
        return ResponseEntity
        		.noContent()
        		.build();
    }
}
