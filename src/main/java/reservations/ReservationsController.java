package reservations;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ReservationsController {

    @RequestMapping("/", method = GET)
    public String index() {
        return "<h1>Reservation index!<h1>";
    }

    @RequestMapping("/health", method = GET)
    public String health() {
        return "ok";
    }

}
