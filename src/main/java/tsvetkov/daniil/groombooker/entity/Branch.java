package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "branches")
@Data
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Integer id;

    private String address;

    private LocalTime workStartTime;

    private LocalTime workEndTime;

    private BigDecimal latitude;

    private BigDecimal longitude;

}

