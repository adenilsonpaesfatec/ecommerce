package br.com.ecommerce.controller;

import br.com.ecommerce.dto.PagamentoDTO;
import br.com.ecommerce.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
@Validated
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> listarTodos() {
        List<PagamentoDTO> pagamentos = pagamentoService
        		.listarTodos();
        return ResponseEntity
        		.ok(pagamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> buscarPorId(@PathVariable Long id) {
        return pagamentoService
        		.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Pagamento não encontrado"));
    }

    @PostMapping
    public ResponseEntity<PagamentoDTO> criar(@Valid @RequestBody PagamentoDTO pagamentoDTO) {
        PagamentoDTO novoPagamento = pagamentoService
        		.salvar(pagamentoDTO);
        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(novoPagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PagamentoDTO pagamentoDTO) {
        pagamentoService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Pagamento não encontrado"));
        pagamentoDTO
        .setId(id);
        PagamentoDTO pagamentoAtualizado = pagamentoService
        		.salvar(pagamentoDTO);
        return ResponseEntity
        		.ok(pagamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pagamentoService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Pagamento não encontrado"));
        pagamentoService
        .deletarPorId(id);
        return ResponseEntity
        		.noContent()
        		.build();
    }
}
