package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Embeddable
@Data
public class ServiceCostId {
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service serviceId;

    @ManyToOne
    @JoinColumn(name = "barber_grade_id")
    private BarberGrade barberGradeId;
}
