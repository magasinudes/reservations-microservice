package reservations;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ReservationsController {

    @RequestMapping(value = "/", method = GET)
    @RequestBody
    public String index() {
        return "<h1>Reservation index!<h1>";
    }

    @RequestMapping(value = "/health", method = GET)
    @RequestBody
    public String health() {
        return "ok";
    }

}
