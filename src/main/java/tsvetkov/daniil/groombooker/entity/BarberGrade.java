package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
public class BarberGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long barberGradeId;

    private String gradeName;
}

