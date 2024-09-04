package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @OneToOne
    @JoinColumn
    private UserInfo userInfoId;
    private String password;

    @ManyToOne
    @JoinColumn
    private Role roleId;
}
