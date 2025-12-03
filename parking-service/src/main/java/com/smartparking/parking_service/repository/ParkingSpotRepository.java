package com.smartparking.parking_service.repository;

import com.smartparking.parking_service.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "parkingSpots", path = "parkingSpots")
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
}
