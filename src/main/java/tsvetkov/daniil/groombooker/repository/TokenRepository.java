package tsvetkov.daniil.groombooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tsvetkov.daniil.groombooker.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, String> {
}
