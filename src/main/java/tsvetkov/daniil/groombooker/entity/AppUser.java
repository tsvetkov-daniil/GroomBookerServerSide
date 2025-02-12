package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
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

    @NonNull
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public AppUser(@NonNull UserInfo userInfo, @NonNull String password, @NonNull Role role) {
        this.userInfo = userInfo;
        this.password = password;
        this.role = role;
    }

    public AppUser(int id, @NonNull UserInfo userInfo, @NonNull String password, @NonNull Role role) {
        this(userInfo,password,role);
        this.id = id;
    }
}
