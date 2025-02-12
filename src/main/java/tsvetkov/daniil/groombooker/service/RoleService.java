package tsvetkov.daniil.groombooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsvetkov.daniil.groombooker.dto.RoleDTO;
import tsvetkov.daniil.groombooker.dto.convert.RoleConverter;
import tsvetkov.daniil.groombooker.entity.Role;
import tsvetkov.daniil.groombooker.repository.RoleRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleConverter converter;

    public List<RoleDTO> getAll() {
        List<Role> lst = roleRepository.findAll();
        return lst.stream()
                .map(converter::enitytToDto)
                .collect(Collectors.toList());
    }

    public RoleDTO save(RoleDTO dto) {
        Role role = roleRepository.save(converter.dtoToEntity(dto));
        return converter.enitytToDto(role);
    }

    public Set<RoleDTO> save(Set<RoleDTO> dto) {
        Set<Role> role = dto.stream().map(converter::dtoToEntity).map(roleRepository::save).collect(Collectors.toSet());
        return role.stream().map(converter::enitytToDto).collect(Collectors.toSet());
    }

    public RoleDTO getDefault()
    {
        return converter.enitytToDto(roleRepository.getById(0));
    }
}
