package com.smartparking.parking_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String number;
    private String status; // DISPONIBLE, OCCUPE
    
    @ManyToOne
    @JoinColumn(name = "parking_zone_id")
    private ParkingZone parkingZone;
}
