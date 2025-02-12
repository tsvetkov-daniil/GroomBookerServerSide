package tsvetkov.daniil.groombooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsvetkov.daniil.groombooker.dto.AppUserDTO;
import tsvetkov.daniil.groombooker.dto.UserInfoDTO;
import tsvetkov.daniil.groombooker.dto.convert.RoleConverter;
import tsvetkov.daniil.groombooker.entity.AppUser;
import tsvetkov.daniil.groombooker.entity.UserInfo;
import tsvetkov.daniil.groombooker.repository.AppUserRepository;

import java.util.Objects;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RoleService roleService;

    public AppUser createUser(AppUserDTO appUserDTO) {
        if (Objects.isNull(appUserDTO.getUserInfo()) ||
                appUserDTO.getPassword().isEmpty())
            return null;

        UserInfo userInfo = userInfoService.save(appUserDTO.getUserInfo());
        if (Objects.isNull(userInfo))
            return null;

        UserInfoDTO UIRequest = appUserDTO.getUserInfo();
        RoleConverter converter = new RoleConverter();
        AppUser appUser = new AppUser(userInfo,appUserDTO.getPassword(), converter.dtoToEntity(roleService.getDefault()));
        appUser.setUserInfo(userInfo);
        System.out.println(appUser.getUserInfo().toString());
        return this.appUserRepository.save(appUser);
    }

}
