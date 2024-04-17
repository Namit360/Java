package com.Hotel.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Hotel.model.Guest;
import com.Hotel.repository.GuestRepository;
import com.Hotel.service.GuestService;
import com.Hotel.exception.GuestNotFoundException;

@Service
public class GuestServiceImplementation implements GuestService{

    @Autowired
    private GuestRepository repo;
    
    @Autowired
    RestTemplate restTemplate;

    @Override
    public Guest saveGuest(Guest guest) {
       return repo.save(guest);
    }

    @Override
    public List<Guest> getAllGuest() {
       return repo.findAll();
    }

    @Override
    public Guest getGuestById(Long id) {
       Optional<Guest> opt = repo.findById(id);
       if(opt.isPresent()) {
           return opt.get();
       } else {
           throw new GuestNotFoundException("Guest Not Found or Not Exists!");
       }
    }

    @Override
    public void deleteGuestById(Long id) {
       repo.delete(getGuestById(id)); 
    }

    @Override
    public void updateGuest(Guest guest) {
       repo.save(guest);
    }

	@Override
	public Object fetchRoom() {
		return restTemplate.getForObject("http://localhost:8080/v1/getAllRooms",Object.class);
	}

}