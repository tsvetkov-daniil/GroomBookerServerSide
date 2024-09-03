package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Token {

    @Id
    private String token;

    private boolean isActive;
}

