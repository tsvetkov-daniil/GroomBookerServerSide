package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "barber_grades")
public class BarberGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "barber_grade_id")
    private Integer id;

    @Column(name = "grade_name")
    private String name;
}

