package br.com.ecommerce.service;

import br.com.ecommerce.dto.RoleDTO;
import br.com.ecommerce.mapper.RoleMapper;
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
    
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleDTO salvar(RoleDTO roleDTO) {
        RoleModel roleModel = roleMapper
        		.toRoleModel(roleDTO);
        RoleModel savedRole = roleRepository
        		.save(roleModel);
        return roleMapper
        		.toRoleDTO(savedRole);
    }

    @Override
    public Optional<RoleDTO> buscarPorId(Long id) {
        return roleRepository
        		.findById(id)
        		.map(roleMapper::toRoleDTO);
    }

    @Override
    public List<RoleDTO> listarTodos() {
        return roleRepository
        		.findAll()
        		.stream()
        		.map(roleMapper::toRoleDTO)
        		.collect(Collectors
        				.toList());
    }

    @Override
    public void deletarPorId(Long id) {
        roleRepository
        .deleteById(id);
    }

}
