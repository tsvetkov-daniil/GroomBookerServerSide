package tsvetkov.daniil.groombooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tsvetkov.daniil.groombooker.entity.ServiceCost;
import tsvetkov.daniil.groombooker.entity.ServiceCostId;

public interface ServiceCostRepository extends JpaRepository<ServiceCost, ServiceCostId> {
}
