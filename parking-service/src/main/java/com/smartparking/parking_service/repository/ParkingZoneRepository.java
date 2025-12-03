package com.smartparking.parking_service.repository;

import com.smartparking.parking_service.model.ParkingZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "parkingZones", path = "parkingZones")
public interface ParkingZoneRepository extends JpaRepository<ParkingZone, Long> {
}
