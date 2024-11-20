package br.com.ecommerce.controller;

import br.com.ecommerce.dto.MetodoPagamentoDTO;
import br.com.ecommerce.service.MetodoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/metodos-pagamento")
@Validated
public class MetodoPagamentoController {

    @Autowired
    private MetodoPagamentoService metodoPagamentoService;

    @GetMapping
    public ResponseEntity<List<MetodoPagamentoDTO>> listarTodos() {
        List<MetodoPagamentoDTO> metodosPagamento = metodoPagamentoService
        		.listarTodos();
        return ResponseEntity
        		.ok(metodosPagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPagamentoDTO> buscarPorId(@PathVariable Long id) {
        return metodoPagamentoService
        		.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Método de pagamento não encontrado"));
    }

    @PostMapping
    public ResponseEntity<MetodoPagamentoDTO> criar(@Valid @RequestBody MetodoPagamentoDTO metodoPagamentoDTO) {
        MetodoPagamentoDTO novoMetodoPagamento = metodoPagamentoService
        		.salvar(metodoPagamentoDTO);
        return ResponseEntity
        		.status(HttpStatus
        				.CREATED)
        		.body(novoMetodoPagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPagamentoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody MetodoPagamentoDTO metodoPagamentoDTO) {
        metodoPagamentoService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Método de pagamento não encontrado"));
        metodoPagamentoDTO.setId(id);
        MetodoPagamentoDTO metodoPagamentoAtualizado = metodoPagamentoService
        		.salvar(metodoPagamentoDTO);
        return ResponseEntity
        		.ok(metodoPagamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        metodoPagamentoService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Método de pagamento não encontrado"));
        metodoPagamentoService
        .deletarPorId(id);
        return ResponseEntity
        		.noContent()
        		.build();
    }
}
