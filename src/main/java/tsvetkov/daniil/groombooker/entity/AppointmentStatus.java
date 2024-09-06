package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class AppointmentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentStatusId;

    private String appointmentStatusName;
}

