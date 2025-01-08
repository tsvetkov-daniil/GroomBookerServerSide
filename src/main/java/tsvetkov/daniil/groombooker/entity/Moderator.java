package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "moderators")
public class Moderator {

    @Id
    @Column(name = "moderator_id")
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "moderator_id")
    private AppUser userId;
}

