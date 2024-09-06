package tsvetkov.daniil.groombooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tsvetkov.daniil.groombooker.entity.Moderator;

@Repository
public interface ModeratorRepository extends JpaRepository<Moderator,Integer> {
}
