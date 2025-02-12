package tsvetkov.daniil.groombooker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoDTO {
    private Integer userInfoId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
