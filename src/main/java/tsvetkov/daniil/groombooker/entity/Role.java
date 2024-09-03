package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;


    private String roleName;

}

