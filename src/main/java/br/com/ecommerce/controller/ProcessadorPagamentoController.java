package br.com.ecommerce.controller;

import br.com.ecommerce.dto.ProcessadorPagamentoDTO;
import br.com.ecommerce.service.ProcessadorPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/processadores-pagamento")
public class ProcessadorPagamentoController {

    @Autowired
    private ProcessadorPagamentoService processadorPagamentoService;

    @GetMapping
    public ResponseEntity<List<ProcessadorPagamentoDTO>> listarTodos() {
        List<ProcessadorPagamentoDTO> processadoresPagamento = processadorPagamentoService.listarTodos();
        return ResponseEntity.ok(processadoresPagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessadorPagamentoDTO> buscarPorId(@PathVariable Long id) {
        Optional<ProcessadorPagamentoDTO> processadorPagamento = processadorPagamentoService.buscarPorId(id);
        return processadorPagamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProcessadorPagamentoDTO> criar(@RequestBody ProcessadorPagamentoDTO processadorPagamentoDTO) {
        ProcessadorPagamentoDTO novoProcessadorPagamento = processadorPagamentoService.salvar(processadorPagamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProcessadorPagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcessadorPagamentoDTO> atualizar(@PathVariable Long id, @RequestBody ProcessadorPagamentoDTO processadorPagamentoDTO) {
        if (!processadorPagamentoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        processadorPagamentoDTO.setId(id);
        ProcessadorPagamentoDTO processadorPagamentoAtualizado = processadorPagamentoService.salvar(processadorPagamentoDTO);
        return ResponseEntity.ok(processadorPagamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!processadorPagamentoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        processadorPagamentoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
