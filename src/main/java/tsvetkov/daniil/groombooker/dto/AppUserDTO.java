package tsvetkov.daniil.groombooker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUserDTO {
    private Integer userId;
    private UserInfoDTO userInfo;
    private String password;


}
