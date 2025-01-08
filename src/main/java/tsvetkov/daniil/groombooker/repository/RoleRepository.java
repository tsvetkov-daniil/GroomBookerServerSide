package tsvetkov.daniil.groombooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tsvetkov.daniil.groombooker.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role getByName(String roleName);
    Role getById(Integer roelId);

}
