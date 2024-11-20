package br.com.ecommerce.controller;

import br.com.ecommerce.dto.ItemPedidoDTO;
import br.com.ecommerce.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/itens-pedido")
@Validated
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedidoDTO>> listarTodos() {
        List<ItemPedidoDTO> itensPedido = itemPedidoService
        		.listarTodos();
        return ResponseEntity
        		.ok(itensPedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> buscarPorId(@PathVariable Long id) {
        return itemPedidoService
        		.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Item do pedido não encontrado"));
    }

    @PostMapping
    public ResponseEntity<ItemPedidoDTO> criar(@Valid @RequestBody ItemPedidoDTO itemPedidoDTO) {
        ItemPedidoDTO novoItemPedido = itemPedidoService
        		.salvar(itemPedidoDTO);
        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(novoItemPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ItemPedidoDTO itemPedidoDTO) {
        itemPedidoService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Item do pedido não encontrado"));
        itemPedidoDTO
        .setId(id);
        ItemPedidoDTO itemPedidoAtualizado = itemPedidoService
        		.salvar(itemPedidoDTO);
        return ResponseEntity
        		.ok(itemPedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        itemPedidoService
        .buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus
                		.NOT_FOUND, "Item do pedido não encontrado"));
        itemPedidoService
        .deletarPorId(id);
        return ResponseEntity
        		.noContent()
        		.build();
    }
}
