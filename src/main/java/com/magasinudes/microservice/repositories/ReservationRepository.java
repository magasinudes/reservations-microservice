package com.magasinudes.microservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.magasinudes.microservice.models.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	Page<Reservation> findByReservationId(Long reservationID, Pageable pageable);
}

