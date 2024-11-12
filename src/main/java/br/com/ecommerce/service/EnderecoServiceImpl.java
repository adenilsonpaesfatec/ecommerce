package br.com.ecommerce.service;

import br.com.ecommerce.dto.EnderecoDTO;
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

    @Override
    public EnderecoDTO salvar(EnderecoDTO enderecoDTO) {
        EnderecoModel enderecoModel = toEnderecoModel(enderecoDTO);
        EnderecoModel savedEndereco = enderecoRepository.save(enderecoModel);
        return toEnderecoDTO(savedEndereco);
    }

    @Override
    public Optional<EnderecoDTO> buscarPorId(Long id) {
        return enderecoRepository.findById(id).map(this::toEnderecoDTO);
    }

    @Override
    public List<EnderecoDTO> listarTodos() {
        return enderecoRepository.findAll().stream().map(this::toEnderecoDTO).collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        enderecoRepository.deleteById(id);
    }

    private EnderecoDTO toEnderecoDTO(EnderecoModel endereco) {
        EnderecoDTO dto = new EnderecoDTO();
        dto.setId(endereco.getId());
        dto.setLogradouro(endereco.getLogradouro());
        dto.setCidade(endereco.getCidade());
        dto.setEstado(endereco.getEstado());
        dto.setCep(endereco.getCep());
        return dto;
    }

    private EnderecoModel toEnderecoModel(EnderecoDTO dto) {
        EnderecoModel endereco = new EnderecoModel();
        endereco.setId(dto.getId());
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setCidade(dto.getCidade());
        endereco.setEstado(dto.getEstado());
        endereco.setCep(dto.getCep());
        return endereco;
    }
}
