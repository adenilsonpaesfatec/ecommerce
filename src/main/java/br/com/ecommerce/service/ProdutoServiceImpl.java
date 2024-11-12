package br.com.ecommerce.service;

import br.com.ecommerce.dto.ProdutoDTO;
import br.com.ecommerce.model.ProdutoModel;
import br.com.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public ProdutoDTO salvar(ProdutoDTO produtoDTO) {
        ProdutoModel produtoModel = toProdutoModel(produtoDTO);
        ProdutoModel savedProduto = produtoRepository.save(produtoModel);
        return toProdutoDTO(savedProduto);
    }

    @Override
    public Optional<ProdutoDTO> buscarPorId(Long id) {
        return produtoRepository.findById(id).map(this::toProdutoDTO);
    }

    @Override
    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll().stream().map(this::toProdutoDTO).collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        produtoRepository.deleteById(id);
    }

    private ProdutoDTO toProdutoDTO(ProdutoModel produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setPreco(produto.getPreco());
        dto.setEstoque(produto.getEstoque());
        // Conversão de categoria
        return dto;
    }

    private ProdutoModel toProdutoModel(ProdutoDTO dto) {
        ProdutoModel produto = new ProdutoModel();
        produto.setId(dto.getId());
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setEstoque(dto.getEstoque());
        // Conversão da categoria do DTO para o modelo, se necessário
        return produto;
    }
}
