package tsvetkov.daniil.groombooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler;
import org.springframework.stereotype.Repository;
import tsvetkov.daniil.groombooker.entity.AppointmentStatus;

@Repository
public interface AppointmentStatusRepository extends JpaRepository<AppointmentStatus, Integer> {
}
