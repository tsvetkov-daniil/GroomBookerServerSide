package tsvetkov.daniil.groombooker.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsvetkov.daniil.groombooker.entity.UserInfo;
import tsvetkov.daniil.groombooker.exception.InvalidEmailException;
import tsvetkov.daniil.groombooker.exception.InvalidNameException;
import tsvetkov.daniil.groombooker.exception.InvalidPhoneNumberException;
import tsvetkov.daniil.groombooker.repository.UserInfoRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfo;

    public Optional<UserInfo> findById(Integer id) {
        return userInfo.findById(id);
    }

    public UserInfo save(UserInfo userInfo) {
        isValidName(userInfo.getFirstName());
        isValidName(userInfo.getMiddleName());
        isValidPhoneNumber(userInfo.getPhoneNumber());
        isValidEmail(userInfo.getEmail());

        return this.userInfo.save(userInfo);
    }


    public UserInfo update(Integer id, UserInfo userInfoDetails) {
        return userInfo.findById(id)
                .map(userInfo -> {
                    if (isValidName(userInfoDetails.getFirstName()))
                        userInfo.setFirstName(userInfoDetails.getFirstName());
                    if (isValidName(userInfoDetails.getMiddleName()))
                        userInfo.setMiddleName(userInfoDetails.getMiddleName());
                    if (isValidPhoneNumber(userInfoDetails.getPhoneNumber()))
                        userInfo.setPhoneNumber(userInfoDetails.getPhoneNumber());
                    if (isValidEmail(userInfoDetails.getEmail()))
                        userInfo.setEmail(userInfoDetails.getEmail());
                    return this.userInfo.save(userInfo);
                })
                .orElseThrow(() -> new RuntimeException("UserInfo not found with id " + id));
    }

    protected void deleteUserInfo(Integer id) {
        if (userInfo.existsById(id)) {
            userInfo.deleteById(id);
        } else {
            throw new RuntimeException("UserInfo not found with id " + id);
        }
    }

    private boolean isValidEmail(String email) {
        String regex = "^(?!.*\\.\\.)(?!.*__)(?!^[._])(?!.*[._]$)[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!isValidData(email, regex)) {
            throw new InvalidEmailException("Invalid email format");
        }
        return true;
    }

    private boolean isValidName(String name) {
        String regex = "^[A-Za-zА-Яа-яЁё]{1,20}$"; // Имя должно содержать только буквы и длину от 1 до 20 символов
        if (!isValidData(name, regex)) {
            throw new InvalidNameException("Invalid name format");
        }
        return true;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\+[0-9]{11}$"; // Телефонный номер должен начинаться с + и содержать ровно 11 цифр
        if (!isValidData(phoneNumber, regex)) {
            throw new InvalidPhoneNumberException("Invalid phone number format");
        }
        return true;
    }

    private boolean isValidData(String data, String regex) {
        return data != null && data.matches(regex);
    }

}

