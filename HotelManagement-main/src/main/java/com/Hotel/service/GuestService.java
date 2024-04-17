package com.Hotel.service;

import java.util.List;
import com.Hotel.model.Guest;

public interface GuestService {

    public Guest saveGuest(Guest guest);
    public List<Guest> getAllGuest();
    public Guest getGuestById(Long id);
    public void deleteGuestById(Long id);
    public void updateGuest(Guest guest);
    //Rest Template Implementation for Fetching data From The Room
    public Object fetchRoom();

}