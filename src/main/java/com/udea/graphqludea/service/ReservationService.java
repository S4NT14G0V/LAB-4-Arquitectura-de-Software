package com.udea.graphqludea.service;

import com.udea.graphqludea.entity.Flight;
import com.udea.graphqludea.entity.Reservation;
import com.udea.graphqludea.repository.FlightRepository;
import com.udea.graphqludea.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final FlightRepository flightRepository;

    public ReservationService(ReservationRepository reservationRepository, FlightRepository flightRepository) {
        this.reservationRepository = reservationRepository;
        this.flightRepository = flightRepository;
    }

    public Reservation reserveFlight(Long flightId, String passengerName, String seatNumber) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new RuntimeException("Flight not found"));
        if (flight.getSeatsAvailable() > 0) {
            flight.setSeatsAvailable(flight.getSeatsAvailable() - 1);

            // Crear la reserva
            Reservation reservation = new Reservation();
            reservation.setPassengerName(passengerName);
            reservation.setSeatNumber(seatNumber);
            reservation.setFlight(flight);

            // Generar el código de reserva
            String reservationCode = generateReservationCode(flight.getFlightNumber());
            reservation.setReservationCode(reservationCode);

            return reservationRepository.save(reservation);
        } else {
            throw new RuntimeException("No seats available");
        }
    }

    // Método para generar un código único de reserva
    private String generateReservationCode(String flightNumber) {
        return flightNumber + "-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}