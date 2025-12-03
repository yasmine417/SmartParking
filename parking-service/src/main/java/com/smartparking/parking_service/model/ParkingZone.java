package com.smartparking.parking_service.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class ParkingZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private int level;
    
    @OneToMany(mappedBy = "parkingZone", cascade = CascadeType.ALL)
    private List<ParkingSpot> parkingSpots;
}
