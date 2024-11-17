package br.com.ecommerce.service;

import br.com.ecommerce.dto.ProdutoDTO;
import br.com.ecommerce.mapper.ProdutoMapper;
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
    
    @Autowired
    private ProdutoMapper produtoMapper;

    @Override
    public ProdutoDTO salvar(ProdutoDTO produtoDTO) {
        ProdutoModel produtoModel = produtoMapper
        		.toProdutoModel(produtoDTO);
        ProdutoModel savedProduto = produtoRepository
        		.save(produtoModel);
        return produtoMapper
        		.toProdutoDTO(savedProduto);
    }

    @Override
    public Optional<ProdutoDTO> buscarPorId(Long id) {
        return produtoRepository
        		.findById(id)
        		.map(produtoMapper::toProdutoDTO);
    }

    @Override
    public List<ProdutoDTO> listarTodos() {
        return produtoRepository
        		.findAll()
        		.stream()
        		.map(produtoMapper::toProdutoDTO)
        		.collect(Collectors
        				.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        produtoRepository
        .deleteById(id);
    }

}
