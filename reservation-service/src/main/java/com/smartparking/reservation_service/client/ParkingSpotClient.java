package com.smartparking.reservation_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "parking-service", url = "http://localhost:8081")
public interface ParkingSpotClient {
    @GetMapping("/parkingSpots/{id}/reserve-check")
    String checkSpotAvailability(@PathVariable("id") Long id);
}
