package br.com.ecommerce.service;

import br.com.ecommerce.dto.CategoriaDTO;
import br.com.ecommerce.mapper.CategoriaMapper;
import br.com.ecommerce.model.CategoriaModel;
import br.com.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public CategoriaDTO salvar(CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaModel = categoriaMapper
        		.toCategoriaModel(categoriaDTO);
        CategoriaModel savedCategoria = categoriaRepository
        		.save(categoriaModel);
        return categoriaMapper
        		.toCategoriaDTO(savedCategoria);
    }

    @Override
    public Optional<CategoriaDTO> buscarPorId(Long id) {
        return categoriaRepository
        		.findById(id)
        		.map(categoriaMapper::toCategoriaDTO);
    }

    @Override
    public List<CategoriaDTO> listarTodos() {
        return categoriaRepository
        		.findAll()
        		.stream()
        		.map(categoriaMapper::toCategoriaDTO)
        		.collect(Collectors
        				.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        categoriaRepository
        .deleteById(id);
    }

}
