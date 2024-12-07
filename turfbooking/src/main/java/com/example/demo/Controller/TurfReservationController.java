package com.example.demo.Controller;

import com.example.demo.Model.TurfReservation;
import com.example.demo.Service.TurfReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class TurfReservationController {

    @Autowired
    private TurfReservationService service;

    @PostMapping("/book")
    public ResponseEntity<String> bookTurf(@RequestBody TurfReservation reservation) {
        // Set the default status to "Pending" for new reservations
        reservation.setStatus("Pending");
        service.saveReservation(reservation);
        return ResponseEntity.ok("Reservation successful.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurfReservation> getReservationById(@PathVariable Long id) {
        Optional<TurfReservation> reservation = service.getReservationById(id);
        return reservation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TurfReservation>> getAllReservations() {
        return ResponseEntity.ok(service.getAllReservations());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReservation(@PathVariable Long id, @RequestBody TurfReservation reservation) {
        if (service.updateReservation(id, reservation)) {
            return ResponseEntity.ok("Reservation updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id) {
        if (service.deleteReservation(id)) {
            return ResponseEntity.ok("Reservation deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
