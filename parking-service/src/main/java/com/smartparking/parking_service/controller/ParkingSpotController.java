package com.smartparking.parking_service.controller;

import com.smartparking.parking_service.model.ParkingSpot;
import com.smartparking.parking_service.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkingSpots")
public class ParkingSpotController {

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    // Vérifier disponibilité d’une place
    @GetMapping("/{id}/reserve-check")
    public ResponseEntity<String> checkAvailability(@PathVariable Long id) {
        return parkingSpotRepository.findById(id)
                .map(spot -> ResponseEntity.ok(spot.getStatus()))
                .orElse(ResponseEntity.notFound().build());
    }

    // Réserver une place
    @PostMapping("/{id}/reserve")
    public ResponseEntity<String> reserveSpot(@PathVariable Long id) {
        return parkingSpotRepository.findById(id)
                .map(spot -> {
                    if ("DISPONIBLE".equals(spot.getStatus())) {
                        spot.setStatus("OCCUPE");
                        parkingSpotRepository.save(spot);
                        return ResponseEntity.ok("Place réservée !");
                    } else {
                        return ResponseEntity.ok("Place déjà occupée");
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
