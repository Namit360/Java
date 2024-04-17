package com.Hotel.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Hotel.model.Guest;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

}