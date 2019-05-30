package reservations;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class ReservationsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "<h1>Reservation index!<h1>";
    }

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health() {
        return "ok";
    }

}
