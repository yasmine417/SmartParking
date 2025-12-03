package com.smartparking.reservation_service.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long parkingSpotId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status; // ACTIVE, CANCELLED, COMPLETED
}
