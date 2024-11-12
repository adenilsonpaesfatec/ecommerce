package br.com.ecommerce.controller;

import br.com.ecommerce.dto.MetodoPagamentoDTO;
import br.com.ecommerce.service.MetodoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/metodos-pagamento")
public class MetodoPagamentoController {

    @Autowired
    private MetodoPagamentoService metodoPagamentoService;

    @GetMapping
    public ResponseEntity<List<MetodoPagamentoDTO>> listarTodos() {
        List<MetodoPagamentoDTO> metodosPagamento = metodoPagamentoService.listarTodos();
        return ResponseEntity.ok(metodosPagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPagamentoDTO> buscarPorId(@PathVariable Long id) {
        Optional<MetodoPagamentoDTO> metodoPagamento = metodoPagamentoService.buscarPorId(id);
        return metodoPagamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MetodoPagamentoDTO> criar(@RequestBody MetodoPagamentoDTO metodoPagamentoDTO) {
        MetodoPagamentoDTO novoMetodoPagamento = metodoPagamentoService.salvar(metodoPagamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMetodoPagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPagamentoDTO> atualizar(@PathVariable Long id, @RequestBody MetodoPagamentoDTO metodoPagamentoDTO) {
        if (!metodoPagamentoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        metodoPagamentoDTO.setId(id);
        MetodoPagamentoDTO metodoPagamentoAtualizado = metodoPagamentoService.salvar(metodoPagamentoDTO);
        return ResponseEntity.ok(metodoPagamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!metodoPagamentoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        metodoPagamentoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
