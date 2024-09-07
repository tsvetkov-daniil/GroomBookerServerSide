package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userInfoId;

    @NonNull
    private String firstName;
    @NonNull
    private String middleName;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String email;

    protected UserInfo(){}
}

