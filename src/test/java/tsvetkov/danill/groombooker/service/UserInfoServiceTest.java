package tsvetkov.danill.groombooker.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import tsvetkov.daniil.Main;
import tsvetkov.daniil.groombooker.dto.UserInfoDTO;
import tsvetkov.daniil.groombooker.entity.UserInfo;
import tsvetkov.daniil.groombooker.service.UserInfoService;

@SpringBootTest(classes = Main.class)
@Transactional
@Rollback
@DisplayName("Запись UserInfo")
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;
    private UserInfo userInfo;

    static final String firstName = "testFirstName";
    static final String lastName = "testMiddleName";
    static final String phoneNumber = "+79996754530";
    static final String email = "test_client@gmail.com";

    @BeforeEach
    public void init() {
        this.userInfo = new UserInfo(firstName, lastName, phoneNumber, email);
    }

    @Test
    @DisplayName("Save UserInfo")
    public void saveUserInfoTest() {
        userInfoService.save(userInfo);

        Assertions.assertNotNull(userInfo.getId());
        Assertions.assertNotNull(userInfoService.getById(userInfo.getId()));

        UserInfo savedUserInfo = userInfoService.getById(userInfo.getId());

        Assertions.assertEquals(firstName, savedUserInfo.getFirstName());
        Assertions.assertEquals(lastName, savedUserInfo.getLastName());
        Assertions.assertEquals(phoneNumber, savedUserInfo.getPhoneNumber());
        Assertions.assertEquals(email, savedUserInfo.getEmail());
    }

    @Test
    @DisplayName("Update UserInfo")
    public void updateUserInfo() {
        userInfoService.save(userInfo);

        final int id = userInfo.getId();

        final String newFirstName = "Aaron";
        final String newMiddleName = "Paul";
        final String newEmail = "test@localhost.com";
        final String newPhoneNumber = "+79990007788";

        UserInfoDTO userInfoDTO = UserInfoDTO.builder()
                .userInfoId(id)
                .firstName(newFirstName)
                .lastName(newMiddleName)
                .email(newEmail)
                .phoneNumber(newPhoneNumber)
                .build();

        userInfoService.update(userInfoDTO);

        UserInfo updatedUserInfo = userInfoService.getById(id);
        Assertions.assertEquals(newFirstName, updatedUserInfo.getFirstName());
        Assertions.assertEquals(newMiddleName, updatedUserInfo.getLastName());
        Assertions.assertEquals(newPhoneNumber, updatedUserInfo.getPhoneNumber());
        Assertions.assertEquals(newEmail, updatedUserInfo.getEmail());
    }

    @Test
    @DisplayName("Delete UserInfo")
    public void removeUserInfo() {
        userInfoService.save(userInfo);
        Assertions.assertNotNull(userInfoService.getById(userInfo.getId()));

        Assertions.assertTrue(userInfoService.deleteById(userInfo.getId()));

        Assertions.assertThrows(JpaObjectRetrievalFailureException.class,
                () -> userInfoService.getById(userInfo.getId()));
    }
}

