package com.Hotel.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotel.exception.ReservationNotFoundException;
import com.Hotel.model.Reservation;
import com.Hotel.repository.ReservationRepository;
import com.Hotel.service.ReservationService;


@Service
public class ReservationServiceImplementation implements ReservationService{

    @Autowired
    private ReservationRepository repo;

    @Override
    public Reservation saveReservation(Reservation reservation) {
       return repo.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservation() {
       return repo.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
       Optional<Reservation> opt = repo.findById(id);
       if(opt.isPresent()) {
           return opt.get();
       } else {
           throw new ReservationNotFoundException("Invoice with Id : "+id+" Not Found");
       }
    }

    @Override
    public void deleteReservationById(Long id) {
       repo.delete(getReservationById(id)); 
    }

    @Override
    public void updateReservation(Reservation reservation) {
       repo.save(reservation);
    }
}