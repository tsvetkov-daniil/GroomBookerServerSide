package tsvetkov.daniil.groombooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsvetkov.daniil.groombooker.dto.UserInfoDTO;
import tsvetkov.daniil.groombooker.entity.UserInfo;
import tsvetkov.daniil.groombooker.repository.UserInfoRepository;

import java.util.Objects;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;


    public boolean exists(UserInfo userInfo){return userInfoRepository.exists(userInfo);}
    public UserInfo getById(Integer id) {
        return userInfoRepository.getById(id);
    }

    public UserInfo save(UserInfo userInfo) {
        return this.userInfoRepository.save(userInfo);
    }


    public UserInfo save(UserInfoDTO userInfoDTO) {
        if (Objects.isNull(userInfoDTO.getFirstName()) ||
                Objects.isNull(userInfoDTO.getLastName()) ||
                Objects.isNull(userInfoDTO.getEmail()) ||
                Objects.isNull(userInfoDTO.getPhoneNumber())) {
            return null;
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName(userInfoDTO.getFirstName());
        userInfo.setLastName(userInfoDTO.getLastName());
        userInfo.setEmail(userInfoDTO.getEmail());
        userInfo.setPhoneNumber(userInfoDTO.getPhoneNumber());

        return this.save(userInfo);
    }


    public UserInfo update(UserInfoDTO userInfoDTO) {
        try {
            UserInfo userInfo = userInfoRepository.getById(userInfoDTO.getUserInfoId());

            if (!userInfoDTO.getFirstName().isEmpty())
                userInfo.setFirstName(userInfoDTO.getFirstName());
            if (!userInfoDTO.getLastName().isEmpty())
                userInfo.setLastName(userInfoDTO.getLastName());
            if (!userInfoDTO.getPhoneNumber().isEmpty())
                userInfo.setPhoneNumber(userInfoDTO.getPhoneNumber());
            if (!userInfoDTO.getEmail().isEmpty())
                userInfo.setEmail(userInfoDTO.getEmail());

            return this.userInfoRepository.save(userInfo);
        } catch (Exception e) {
            System.err.println("Can't update userinfo" + e);
            return null;
        }
    }

    public boolean deleteById(int id) {
        if (userInfoRepository.existsById(id)) {
            userInfoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}

