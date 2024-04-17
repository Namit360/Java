package com.Hotel.service;

import java.util.List;

import com.Hotel.model.Room;

public interface RoomService {
	

	public Room addRoom(Room room);
	public List<Room> fetchAllRooms();
	public Room fetchRoomById(int id);
	public void deleteRoom(int id);
	
	public void updateRoom(int id, Room room);

}
