package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shiftId;

    private LocalDate shiftDate;

    private LocalTime workStartTime;

    private LocalTime workEndTime;

    @ManyToOne
    @JoinColumn
    private Barber barberId;

    @ManyToOne
    @JoinColumn
    private Branch branchId;
}

