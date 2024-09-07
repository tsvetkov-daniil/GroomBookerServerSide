package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer barberId;

    private String barberInfo;

    @ManyToOne
    @JoinColumn
    private BarberGrade barberGradeId;
    @OneToOne
    @JoinColumn
    private AppUser userId;
    
    public String getFirstName()
    {
        return this.getBarberInfo().getFirstName();
    }
    
    public void setFirstName(String firstName)
    {
        this.getBarberInfo().setFirstName(firstName);
    }

    public String getMiddleName()
    {
        return this.getBarberInfo().getMiddleName();
    }

    public void setMiddleName(String middleName)
    {
        this.getBarberInfo().setMiddleName(middleName);
    }
    
    public String getPhoneNumber()
    {
        return this.getBarberInfo().getPhoneNumber();
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.getBarberInfo().setPhoneNumber(phoneNumber);
    }
    
    public String getEmail()
    {
        return this.getBarberInfo().getEmail();
    }

    public void setEmail(String email)
    {
        this.getBarberInfo().setPhoneNumber(email);
    }
    
    public UserInfo getBarberInfo()
    {
        return this.getUserId().getUserInfoId();
    }
}

