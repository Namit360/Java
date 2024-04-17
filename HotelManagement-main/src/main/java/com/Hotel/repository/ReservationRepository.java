package com.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hotel.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	}

