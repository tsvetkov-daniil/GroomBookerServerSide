package tsvetkov.danill.groombooker.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import tsvetkov.daniil.Main;
import tsvetkov.daniil.groombooker.entity.UserInfo;
import tsvetkov.daniil.groombooker.exception.InvalidEmailException;
import tsvetkov.daniil.groombooker.service.UserInfoService;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = Main.class)
//TODO не откатывает данные
@DisplayName("Запись UserInfo")
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;
    private UserInfo userInfo;

    @BeforeEach
    public void init()
    {
        final String firstName = "Алексей";
        final String middleName = "Васильков";
        final String phoneNumber = "+79996754530";
        final String email = "client@gmail.com";

        this.userInfo = new UserInfo(firstName, middleName, phoneNumber, email);
    }

    @Test
    @Rollback
    @Transactional
    @DisplayName("Корректные данные")
    public void insertCorrectUserInfo() {
        userInfoService.save(userInfo);

        Assertions.assertNotNull(userInfo.getUserInfoId());
        Assertions.assertTrue(userInfoService.findById(userInfo.getUserInfoId()).isPresent());

        UserInfo savedUserInfo = userInfoService.findById(userInfo.getUserInfoId()).get();

        Assertions.assertEquals(userInfo.getFirstName(), savedUserInfo.getFirstName());
        Assertions.assertEquals(userInfo.getMiddleName(), savedUserInfo.getMiddleName());
        Assertions.assertEquals(userInfo.getPhoneNumber(), savedUserInfo.getPhoneNumber());
        Assertions.assertEquals(userInfo.getEmail(), savedUserInfo.getEmail());
    }


    @Test
    @DisplayName("Некорректный email")
    public void insertIncorrectEmail() {
        userInfo.setEmail("@incorrect.com");
        assertThrows(InvalidEmailException.class, () -> {
            userInfoService.save(userInfo);
        });

    }
}

