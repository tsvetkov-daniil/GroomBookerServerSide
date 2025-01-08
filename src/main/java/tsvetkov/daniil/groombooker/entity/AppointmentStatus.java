package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "appointment_statuses")
public class AppointmentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_status_id")
    private Integer id;

    @Column(name = "appointment_status_name")
    private String name;
}

