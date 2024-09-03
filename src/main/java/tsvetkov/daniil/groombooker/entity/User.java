package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @OneToOne
    @JoinColumn
    private UserInfo userInfoId;
    private String Password;

    @ManyToOne
    @JoinColumn
    private Role roleId;
}
