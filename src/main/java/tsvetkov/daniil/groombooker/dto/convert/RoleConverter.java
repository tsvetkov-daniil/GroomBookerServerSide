package tsvetkov.daniil.groombooker.dto.convert;

import tsvetkov.daniil.groombooker.dto.RoleDTO;
import tsvetkov.daniil.groombooker.entity.Role;

public class RoleConverter implements Converter<Role, RoleDTO>{
    @Override
    public Role dtoToEntity(RoleDTO dto) {
        if(dto.getName().isEmpty())
            throw new RuntimeException();

        Role role = new Role(dto.getName());
        role.setId(dto.getId());
        return role;
    }

    @Override
    public RoleDTO enitytToDto(Role entity) {
        return new RoleDTO(entity.getId(),entity.getName());
    }
}
