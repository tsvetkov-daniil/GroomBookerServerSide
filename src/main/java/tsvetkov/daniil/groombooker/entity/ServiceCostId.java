package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;

@Embeddable
public class ServiceCostId {
    @ManyToOne
    @JoinColumn
    private Service serviceId;

    @ManyToOne
    @JoinColumn
    private BarberGrade barberGradeId;
}
