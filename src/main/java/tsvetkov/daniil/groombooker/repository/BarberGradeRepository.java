package tsvetkov.daniil.groombooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tsvetkov.daniil.groombooker.entity.BarberGrade;

@Repository
public interface BarberGradeRepository extends JpaRepository<BarberGrade,Integer> {
}
