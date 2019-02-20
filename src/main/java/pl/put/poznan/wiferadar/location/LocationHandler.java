package pl.put.poznan.wiferadar.location;

import lombok.val;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping("/location")
public class LocationHandler {
    @GetMapping
    public Location getLocation(@RequestParam String phoneNumber) {
        return LocationRepository.getInstance().get(phoneNumber);
    }

    @PostMapping
    public boolean addLocation(@RequestParam String phoneNumber, @RequestBody Location location) {
        val repository = LocationRepository.getInstance();
        repository.add(phoneNumber, location);
        return Objects.equals(repository.get(phoneNumber), location);
    }
}
