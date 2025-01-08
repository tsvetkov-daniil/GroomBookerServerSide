package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "service_costs")
public class ServiceCost {

    @EmbeddedId
    private ServiceCostId id;

    @Column(name = "service_cost")
    private Float cost;
}

