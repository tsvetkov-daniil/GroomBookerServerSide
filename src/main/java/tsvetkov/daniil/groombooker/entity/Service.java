package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;

    private String serviceName;

    private Short duration;

    //TODO Добавить коллекцию для услуги грейд-цена
//    @ElementCollection
//    @CollectionTable(name = "service_prices")
//    @MapKeyColumn(name = "barber_grade")
//    @Column(name = "price")
//    private Map<BarberGrade, Double> barberGradePrices = new HashMap<>();
}
