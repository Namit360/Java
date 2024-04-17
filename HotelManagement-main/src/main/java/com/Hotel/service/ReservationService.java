package com.Hotel.service;


import java.util.List;

import com.Hotel.model.Reservation;

public interface ReservationService {

    public Reservation saveReservation(Reservation reservation);
    public List<Reservation> getAllReservation();
    public Reservation getReservationById(Long id);
    public void deleteReservationById(Long id);
    public void updateReservation(Reservation reservation);

}