package com.smartparking.reservation_service.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReservationRequest {
    private Long userId;
    private Long parkingSpotId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
