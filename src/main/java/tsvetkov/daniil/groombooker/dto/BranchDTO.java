package tsvetkov.daniil.groombooker.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalTime;

@Data
@Builder
public class BranchDTO {
    private Integer id;

    private String address;

    private LocalTime workStartTime;

    private LocalTime workEndTime;

    private BigDecimal latitude;

    private BigDecimal longitude;
}
