package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer barberId;

    private String barberInfo;

    @ManyToOne
    @JoinColumn
    private BarberGrade barberGradeId;
    @OneToOne
    @JoinColumn
    private User userId;
}

