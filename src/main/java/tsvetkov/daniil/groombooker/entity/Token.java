package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tokens")
public class Token {

    @Id
    private String token;

    private boolean isActive;
}

