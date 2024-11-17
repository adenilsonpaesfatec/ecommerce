package br.com.ecommerce.service;

import br.com.ecommerce.dto.EnderecoDTO;
import br.com.ecommerce.mapper.EnderecoMapper;
import br.com.ecommerce.model.EnderecoModel;
import br.com.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private EnderecoMapper enderecoMapper;

    @Override
    public EnderecoDTO salvar(EnderecoDTO enderecoDTO) {
        EnderecoModel enderecoModel = enderecoMapper
        		.toEnderecoModel(enderecoDTO);
        EnderecoModel savedEndereco = enderecoRepository
        		.save(enderecoModel);
        return enderecoMapper
        		.toEnderecoDTO(savedEndereco);
    }

    @Override
    public Optional<EnderecoDTO> buscarPorId(Long id) {
        return enderecoRepository
        		.findById(id)
        		.map(enderecoMapper::toEnderecoDTO);
    }

    @Override
    public List<EnderecoDTO> listarTodos() {
        return enderecoRepository
        		.findAll()
        		.stream()
        		.map(enderecoMapper::toEnderecoDTO)
        		.collect(Collectors
        				.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        enderecoRepository
        .deleteById(id);
    }

}
