package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "branches")
@Data
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    private String address;

    private LocalDateTime workStartTime;

    private LocalDateTime workEndTime;

    private BigDecimal latitude;

    private BigDecimal longitude;

}

