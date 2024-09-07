package tsvetkov.daniil.groombooker.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tsvetkov.daniil.groombooker.entity.Barber;
import tsvetkov.daniil.groombooker.entity.UserInfo;
import tsvetkov.daniil.groombooker.repository.BarberRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/barbers")
public class BarberController {

    @Autowired
    private BarberRepository barberRepository;

    @GetMapping
    public List<Barber> getAllBarbers() {
        return barberRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barber> getBarberById(@PathVariable Integer id) {
        Optional<Barber> barber = barberRepository.findById(id);
        return barber.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Barber> createBarber(@RequestBody Barber barber) {
        Barber savedBarber = barberRepository.save(barber);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBarber);
    }

    // Обновление информации о барбере
    @PutMapping("/{id}")
    public ResponseEntity<Barber> updateBarber(@PathVariable Integer id, @RequestBody Barber barberDetails) {
        Optional<Barber> optionalBarber = barberRepository.findById(id);
        if (optionalBarber.isPresent()) {

            Barber barber = optionalBarber.get();
            UserInfo userInfo = barber.getUserId().getUserInfoId();
            userInfo.setFirstName(barberDetails.getUserId().getUserInfoId().getFirstName());
            userInfo.setPhoneNumber(barberDetails.getUserId().getUserInfoId().getPhoneNumber());
            userInfo.setEmail(barberDetails.getEmail());

            Barber updatedBarber = barberRepository.save(barber);
            return ResponseEntity.ok(updatedBarber);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

