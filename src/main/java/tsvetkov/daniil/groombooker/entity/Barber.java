package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "barbers")
public class Barber {

    @Id
    @Column(name = "barber_id")
    private Integer id;

    private String barberInfo;

    @ManyToOne
    @JoinColumn(name = "barber_grade_id")
    private BarberGrade grade;

    @OneToOne
    @MapsId
    @JoinColumn(name = "barber_id")
    private AppUser appUser;

}

