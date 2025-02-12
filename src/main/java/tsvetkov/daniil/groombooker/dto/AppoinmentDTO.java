package tsvetkov.daniil.groombooker.dto;

import lombok.Builder;
import lombok.Data;
import tsvetkov.daniil.groombooker.entity.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class AppoinmentDTO {
    private Integer id;
    private Guest guest;
    private AppUser user;
    private Shift shift;
    private AppointmentStatus status;
    private LocalDateTime time;
    private Set<Service> services;
}
