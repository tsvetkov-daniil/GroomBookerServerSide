package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
public class ServiceCost {

    @EmbeddedId
    private ServiceCostId serviceCostId;

    private Float service_cost;
}

