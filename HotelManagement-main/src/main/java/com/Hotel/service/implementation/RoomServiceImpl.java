package com.Hotel.service.implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotel.model.Room;
import com.Hotel.repository.RoomRepository;
import com.Hotel.service.RoomService;



@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public Room addRoom(Room room) {
		return roomRepository.save(room);
		
	}

	@Override
	public List<Room> fetchAllRooms() {
		List<Room> room=roomRepository.findAll();
		return room;
	}

	@Override
	public Room fetchRoomById(int id) {
		Room room = roomRepository.findById(id).get();
		return room;
	}


//	@Override
//	public void updateRoom(Room room)   
//	{  
//		Room r = roomRepository.findById(id).orElse(null);
//		
//		r.setRoomtype(room.getRoomtype());
//		r.setBedtype(room.getBedtype());
//		r.setVacancy(room.getVacancy());
//		
//		roomRepository.save(r);
//		
//	}
	
    @Override
    public void updateRoom(int id,Room room) {
    	Room r = roomRepository.findById(id).orElse(null);
		
		r.setBedtype(room.getBedtype());
		r.setRoomtype(room.getRoomtype());
		r.setVacancy(room.getVacancy());
		
		roomRepository.save(r);
    }
	
	@Override
	public void deleteRoom(int id) {
		roomRepository.deleteById(id);
	}





}
