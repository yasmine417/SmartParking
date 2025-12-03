package com.smartparking.parking_service.config;

import com.smartparking.parking_service.model.ParkingZone;
import com.smartparking.parking_service.model.ParkingSpot;
import com.smartparking.parking_service.repository.ParkingZoneRepository;
import com.smartparking.parking_service.repository.ParkingSpotRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final ParkingZoneRepository zoneRepository;
    private final ParkingSpotRepository spotRepository;

    public DataInitializer(ParkingZoneRepository zoneRepository, ParkingSpotRepository spotRepository) {
        this.zoneRepository = zoneRepository;
        this.spotRepository = spotRepository;
    }

    @PostConstruct
    public void init() {
        // Créer une zone
        ParkingZone zone = new ParkingZone();
        zone.setName("Zone A");
        zone.setLevel(1);
        zone = zoneRepository.save(zone);

        // Créer 5 places
        for (int i = 1; i <= 5; i++) {
            ParkingSpot spot = new ParkingSpot();
            spot.setNumber("A" + i);
            spot.setStatus("DISPONIBLE");
            spot.setParkingZone(zone);
            spotRepository.save(spot);
        }
    }
}
