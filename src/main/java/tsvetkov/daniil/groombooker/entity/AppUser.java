package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "app_users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @OneToOne
    @NonNull
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;
    @NonNull
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
