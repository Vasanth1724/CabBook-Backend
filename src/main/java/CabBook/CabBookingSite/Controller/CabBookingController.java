package CabBook.CabBookingSite.Controller;

import CabBook.CabBookingSite.Dto.CabBookingRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // allow React frontend
public class CabBookingController {

    @GetMapping("/calculate-fare")
    public double calculateFare(@RequestParam String pickup, @RequestParam String drop) {
        // Dummy logic: Fare = distance × rate_per_km
        // In real case, calculate based on distance API
        double distanceKm = Math.random() * 10 + 1; // 1–10 km random
        double ratePerKm = 15; // ₹15 per km
        return Math.round(distanceKm * ratePerKm * 100.0) / 100.0;
    }

    @PostMapping("/book-cab")
    public String bookCab(@RequestBody CabBookingRequest request) {
        // Normally save booking to DB
        return "Cab booked from " + request.getPickup() + " to " + request.getDrop() + " 🚖";
    }
}
