package br.com.ecommerce.controller;

import br.com.ecommerce.dto.ProcessadorPagamentoDTO;
import br.com.ecommerce.service.ProcessadorPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/processadores-pagamento")
@Validated
public class ProcessadorPagamentoController {

    @Autowired
    private ProcessadorPagamentoService processadorPagamentoService;

    @GetMapping
    public ResponseEntity<List<ProcessadorPagamentoDTO>> listarTodos() {
        List<ProcessadorPagamentoDTO> processadoresPagamento = processadorPagamentoService
        		.listarTodos();
        return ResponseEntity
        		.ok(processadoresPagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessadorPagamentoDTO> buscarPorId(@PathVariable Long id) {
        return processadorPagamentoService
        		.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Processador de pagamento não encontrado"));
    }

    @PostMapping
    public ResponseEntity<ProcessadorPagamentoDTO> criar(@Valid @RequestBody ProcessadorPagamentoDTO processadorPagamentoDTO) {
        ProcessadorPagamentoDTO novoProcessadorPagamento = processadorPagamentoService
        		.salvar(processadorPagamentoDTO);
        return ResponseEntity
        		.status(HttpStatus
        				.CREATED)
        		.body(novoProcessadorPagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcessadorPagamentoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ProcessadorPagamentoDTO processadorPagamentoDTO) {
        processadorPagamentoService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Processador de pagamento não encontrado"));
        processadorPagamentoDTO.setId(id);
        ProcessadorPagamentoDTO processadorPagamentoAtualizado = processadorPagamentoService
        		.salvar(processadorPagamentoDTO);
        return ResponseEntity
        		.ok(processadorPagamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        processadorPagamentoService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Processador de pagamento não encontrado"));
        processadorPagamentoService
        .deletarPorId(id);
        return ResponseEntity
        		.noContent()
        		.build();
    }
}
