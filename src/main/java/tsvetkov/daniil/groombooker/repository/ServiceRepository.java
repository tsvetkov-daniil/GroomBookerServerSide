package tsvetkov.daniil.groombooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tsvetkov.daniil.groombooker.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
