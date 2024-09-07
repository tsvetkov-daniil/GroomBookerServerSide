package tsvetkov.daniil.groombooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tsvetkov.daniil.groombooker.entity.Barber;

@Repository
public interface BarberRepository extends JpaRepository<Barber,Integer> {


}
