package tsvetkov.daniil.groombooker.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Data
@NoArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_info_id")
    private Integer id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String email;
}


//    public void setEmail(String email) {
//        if (isValidEmail(email))
//            this.email = email;
//    }
//
//    public void setFirstName(String firstName) {
//        if (isValidName(firstName))
//            this.firstName = firstName;
//    }
//
//    public void setMiddleName(String middleName) {
//        if (isValidName(middleName))
//            this.middleName = middleName;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        if (isValidPhoneNumber(phoneNumber))
//            this.phoneNumber = phoneNumber;
//    }
//
//    //TODO Сделать валидацию через конструктор
//    private boolean isValidEmail(String email) {
//        String regex = "^(?!.*\\.\\.)(?!.*__)(?!^[._])(?!.*[._]$)[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
//        if (!email.matches(regex)) {
//            throw new InvalidEmailException("Invalid email format");
//        }
//        return true;
//    }
//
//    private boolean isValidName(String name) {
//        String regex = "^[A-Za-zА-Яа-я]{1,45}$";
//        if (!name.matches(regex)) {
//            throw new InvalidNameException("Invalid name format");
//        }
//        return true;
//    }
//
//    private boolean isValidPhoneNumber(String phoneNumber) {
//        String regex = "^\\+[0-9]{11}$";
//        if (!phoneNumber.matches(regex)) {
//            throw new InvalidPhoneNumberException("Invalid phone number format");
//        }
//        return true;
//    }


