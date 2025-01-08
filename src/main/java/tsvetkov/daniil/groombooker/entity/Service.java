package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer id;

    @Column(name = "service_name")
    private String name;

    private Short duration;

    //TODO Добавить коллекцию для услуги грейд-цена
//    @ElementCollection
//    @CollectionTable(name = "service_prices")
//    @MapKeyColumn(name = "barber_grade")
//    @Column(name = "price")
//    private Map<BarberGrade, Double> barberGradePrices = new HashMap<>();
}
