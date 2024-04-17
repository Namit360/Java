package com.Hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Hotel.exception.RoomNotFoundException;
import com.Hotel.model.Room;
import com.Hotel.service.RoomService;

@Controller
@RequestMapping("/v1")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	

	
    @GetMapping("/a")
    public String showHomePage() {
       return "roomHomePage";
    }

    @GetMapping("/register")
    public String showRoomPage() {
       return "addRoomPage";
    }
    
    @GetMapping("/bill/getAllBill")
    public String showBillPage() {
       return "allBillPage";
    }
    
    
    
    
    @PostMapping("/save")	
	public String saveRoom(
            @ModelAttribute Room room,
            Model model
            ) {
        roomService.addRoom(room);
        int id = roomService.addRoom(room).getRoomno();
        String message = "Record with id : '"+id+"' is saved successfully !";
        model.addAttribute("message", message);
        return "addRoomPage";
    }
	
	@GetMapping("/getAllRooms")
    public String getAllRooms(
            @RequestParam(value = "message", required = false) String message,
            Model model
            ) {
       List<Room> room= roomService.fetchAllRooms();
       model.addAttribute("list", room);
       model.addAttribute("message", message);
       return "allRoomPage";
    }
	
	@GetMapping("/room/{id}")
	public Room getRoomById(@PathVariable("id") int id)
	{
       Room room = roomService.fetchRoomById(id);
       return room;
	}
	
	@GetMapping("/edit")
    public String editRoom(
            Model model,
            RedirectAttributes attributes,
            @RequestParam int id
            ) {
       String page = null; 
       try {
       Room room = roomService.fetchRoomById(id);
       model.addAttribute("room", room);
       page="editRoom";
       } catch (RoomNotFoundException e) {
           e.printStackTrace();
           attributes.addAttribute("message", e.getMessage());
           page="redirect:getAllRooms";
       }
       return page; 
    }

    @PostMapping("/update")
    public String updateRoom(
            @ModelAttribute Room room,
            RedirectAttributes attributes
            ) {
       
	
       int id = room.getRoomno();
       roomService.updateRoom(id, room);
       attributes.addAttribute("message", "Room No: '"+id+"' information is updated successfully !");
       return "redirect:getAllRooms";
    }


    
    @GetMapping("/delete")
    public String deleteRoom(@RequestParam int id, RedirectAttributes attributes) {
    	
        try {
        	roomService.deleteRoom(id);
        	attributes.addAttribute("message", "Room No : '"+id+"' is removed successfully!");
        } catch (RoomNotFoundException e) {
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
        }
         String redirect = "redirect:getAllRooms";
         return redirect;
    }
    
   
}
