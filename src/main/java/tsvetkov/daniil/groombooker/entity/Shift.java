package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "shifts")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shift_id")
    private Integer id;

    private LocalDate shiftDate;

    private LocalTime workStartTime;

    private LocalTime workEndTime;

    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barberId;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branchId;
}

