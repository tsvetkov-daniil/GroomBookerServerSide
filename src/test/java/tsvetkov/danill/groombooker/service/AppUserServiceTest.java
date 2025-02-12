package tsvetkov.danill.groombooker.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import tsvetkov.daniil.Main;
import tsvetkov.daniil.groombooker.dto.AppUserDTO;
import tsvetkov.daniil.groombooker.dto.UserInfoDTO;
import tsvetkov.daniil.groombooker.entity.UserInfo;
import tsvetkov.daniil.groombooker.service.AppUserService;
import tsvetkov.daniil.groombooker.service.UserInfoService;

@SpringBootTest(classes = Main.class)
@Transactional
@Rollback
public class AppUserServiceTest {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private UserInfoService userInfoService;

    @Test
    @DisplayName("Save User")
    public void saveUser() {
        UserInfoDTO userInfo = UserInfoDTO.builder()
                .firstName("Виктор")
                .lastName("Шевцов")
                .phoneNumber("+79993330976")
                .email("test@test.com")
                .build();

        UserInfo ui = userInfoService.save(userInfo);
        Assertions.assertTrue(()->  userInfoService.exists(ui));


        AppUserDTO appUserDTO = new AppUserDTO(userInfo, "shjdbfdjshbnf");

//        AppUser appUser = appUserService.createUser(appUserDTO);
//        Assertions.assertNotNull(appUser);
//        Assertions.assertEquals(appUserDTO.getPassword(),appUser.getPassword());
//        Assertions.assertEquals(appUserDTO.getUserInfo().getEmail(), appUser.getUserInfo().getEmail());
//        Assertions.assertEquals(appUserDTO.getUserInfo().getFirstName(), appUser.getUserInfo().getFirstName());
//        Assertions.assertEquals(appUserDTO.getUserInfo().getLastName(), appUser.getUserInfo().getLastName());

    }
}
