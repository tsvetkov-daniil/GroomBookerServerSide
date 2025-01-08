package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_id")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;
}


