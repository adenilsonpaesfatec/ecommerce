package br.com.ecommerce.service;

import br.com.ecommerce.dto.CategoriaDTO;
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

    @Override
    public CategoriaDTO salvar(CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaModel = toCategoriaModel(categoriaDTO);
        CategoriaModel savedCategoria = categoriaRepository.save(categoriaModel);
        return toCategoriaDTO(savedCategoria);
    }

    @Override
    public Optional<CategoriaDTO> buscarPorId(Long id) {
        return categoriaRepository.findById(id).map(this::toCategoriaDTO);
    }

    @Override
    public List<CategoriaDTO> listarTodos() {
        return categoriaRepository.findAll().stream().map(this::toCategoriaDTO).collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        categoriaRepository.deleteById(id);
    }

    private CategoriaDTO toCategoriaDTO(CategoriaModel categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        dto.setDescricao(categoria.getDescricao());
        return dto;
    }

    private CategoriaModel toCategoriaModel(CategoriaDTO dto) {
        CategoriaModel categoria = new CategoriaModel();
        categoria.setId(dto.getId());
        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());
        return categoria;
    }
}
