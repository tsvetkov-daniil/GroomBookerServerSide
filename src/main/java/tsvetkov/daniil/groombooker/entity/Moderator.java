package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Moderator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moderatorId;

    @OneToOne
    @JoinColumn
    private AppUser userId;
}

