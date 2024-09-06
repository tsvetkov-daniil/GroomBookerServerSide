package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ServiceCost {

    @EmbeddedId
    private ServiceCostId serviceCostId;

    private Float cost;
}

