package tsvetkov.daniil.groombooker.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Embeddable
public class AppointmentServiceId implements Serializable {

    @ManyToOne
    @JoinColumn
    private Service serviceId;

    @ManyToOne
    @JoinColumn
    private Appointment appointmentId;



    public AppointmentServiceId(Service serviceId, Appointment appointmentId) {
        this.serviceId = serviceId;
        this.appointmentId = appointmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentServiceId that = (AppointmentServiceId) o;
        return Objects.equals(serviceId, that.serviceId) &&
                Objects.equals(appointmentId, that.appointmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, appointmentId);
    }
}

