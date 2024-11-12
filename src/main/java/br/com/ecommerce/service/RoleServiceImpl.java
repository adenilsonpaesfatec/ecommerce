package br.com.ecommerce.service;

import br.com.ecommerce.dto.RoleDTO;
import br.com.ecommerce.model.RoleModel;
import br.com.ecommerce.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDTO salvar(RoleDTO roleDTO) {
        RoleModel roleModel = toRoleModel(roleDTO);
        RoleModel savedRole = roleRepository.save(roleModel);
        return toRoleDTO(savedRole);
    }

    @Override
    public Optional<RoleDTO> buscarPorId(Long id) {
        return roleRepository.findById(id).map(this::toRoleDTO);
    }

    @Override
    public List<RoleDTO> listarTodos() {
        return roleRepository.findAll().stream().map(this::toRoleDTO).collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        roleRepository.deleteById(id);
    }

    private RoleDTO toRoleDTO(RoleModel role) {
        RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setNome(role.getNome());
        return dto;
    }

    private RoleModel toRoleModel(RoleDTO dto) {
        RoleModel role = new RoleModel();
        role.setId(dto.getId());
        role.setNome(dto.getNome());
        return role;
    }
}
