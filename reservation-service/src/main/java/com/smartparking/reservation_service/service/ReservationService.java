package com.smartparking.reservation_service.service;

import com.smartparking.reservation_service.client.ParkingSpotClient;
import com.smartparking.reservation_service.dto.ReservationRequest;
import com.smartparking.reservation_service.exception.SpotNotAvailableException;
import com.smartparking.reservation_service.model.Reservation;
import com.smartparking.reservation_service.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ParkingSpotClient parkingSpotClient;

    @Transactional
    public Reservation createReservation(ReservationRequest request) {
        // Vérifier disponibilité de la place
        String status = parkingSpotClient.checkSpotAvailability(request.getParkingSpotId());
        if (!"DISPONIBLE".equals(status)) {
            throw new SpotNotAvailableException("Parking spot is not available");
        }

        // Créer et sauvegarder la réservation
        Reservation reservation = new Reservation();
        reservation.setUserId(request.getUserId());
        reservation.setParkingSpotId(request.getParkingSpotId());
        reservation.setStartTime(request.getStartTime());
        reservation.setEndTime(request.getEndTime());
        reservation.setStatus("ACTIVE");

        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public List<Reservation> getReservationsByUser(Long userId) {
        return reservationRepository.findByUserId(userId);
    }
}
