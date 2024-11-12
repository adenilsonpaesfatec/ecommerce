package br.com.ecommerce.controller;

import br.com.ecommerce.dto.ItemPedidoDTO;
import br.com.ecommerce.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedidoDTO>> listarTodos() {
        List<ItemPedidoDTO> itensPedido = itemPedidoService.listarTodos();
        return ResponseEntity.ok(itensPedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> buscarPorId(@PathVariable Long id) {
        Optional<ItemPedidoDTO> itemPedido = itemPedidoService.buscarPorId(id);
        return itemPedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItemPedidoDTO> criar(@RequestBody ItemPedidoDTO itemPedidoDTO) {
        ItemPedidoDTO novoItemPedido = itemPedidoService.salvar(itemPedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoItemPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> atualizar(@PathVariable Long id, @RequestBody ItemPedidoDTO itemPedidoDTO) {
        if (!itemPedidoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        itemPedidoDTO.setId(id);
        ItemPedidoDTO itemPedidoAtualizado = itemPedidoService.salvar(itemPedidoDTO);
        return ResponseEntity.ok(itemPedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!itemPedidoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        itemPedidoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
