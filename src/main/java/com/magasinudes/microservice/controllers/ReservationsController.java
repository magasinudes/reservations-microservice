package com.magasinudes.microservice.controllers;

import com.magasinudes.microservice.exceptions.RecordNotFoundException;
import com.magasinudes.microservice.models.Reservation;
import com.magasinudes.microservice.repositories.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ReservationsController {

	@Autowired
	private ReservationRepository reservationRepository;

	@GetMapping("/reservations")
	public Optional<Reservation> index(@PathVariable Long reservationId) {
		return reservationRepository.findById(reservationId);
	}

	@PostMapping("/reservations")
	public Long create(@Valid @RequestBody Reservation reservation) {
		return reservationRepository.save(reservation).getId();
	}

	@GetMapping("/reservations/{reservationId}")
	public Optional<Reservation> show(@PathVariable Long reservationId) {
		if (!reservationRepository.existsById(reservationId)) {
			throw new RecordNotFoundException("No reservation found with id " + reservationId);
		}

		return reservationRepository.findById(reservationId);
	}

	@PutMapping("/reservations/{reservationId}")
	public Long update(@PathVariable Long reservationId, @Valid @RequestBody Reservation data) {
		if (!reservationRepository.existsById(reservationId)) {
			throw new RecordNotFoundException("No reservation found with id " + reservationId);
		}

		return reservationRepository.findById(reservationId).map(reservation -> {
			if (data.getStartAt() != null) {
				reservation.setStartAt(data.getStartAt());
			}
			if (data.getEndAt() != null) {
				reservation.setEndAt(data.getEndAt());
			}
			if (data.getNote() != null) {
				reservation.setNote(data.getNote());
			}
			if (data.getUserId() != null) {
				reservation.setUserId(data.getUserId());
			}
			if (data.getResourceId() != null) {
				reservation.setResourceId(data.getResourceId());
			}
			return reservationRepository.save(reservation).getId();
		}).orElseThrow(() -> new RecordNotFoundException("No reservation found with id " + reservationId));
	}

	@DeleteMapping("/reservations/{reservationId}")
	public ResponseEntity<?> delete(@PathVariable Long reservationId) {
		if (!reservationRepository.existsById(reservationId)) {
			throw new RecordNotFoundException("No reservation found with id " + reservationId);
		}

		return reservationRepository.findById(reservationId).map(reservation -> {
			reservationRepository.delete(reservation);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new RecordNotFoundException("No reservation found with id " + reservationId));
	}
}
