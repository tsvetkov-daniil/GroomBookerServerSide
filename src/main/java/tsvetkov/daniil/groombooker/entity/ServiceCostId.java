package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Embeddable
@Data
public class ServiceCostId {
    @ManyToOne
    @JoinColumn
    private Service serviceId;

    @ManyToOne
    @JoinColumn
    private BarberGrade barberGradeId;
}
