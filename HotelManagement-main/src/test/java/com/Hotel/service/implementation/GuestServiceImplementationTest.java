package com.Hotel.service.implementation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.Hotel.model.Guest;
import com.Hotel.repository.GuestRepository;
@ExtendWith(SpringExtension.class)
class GuestServiceImplementationTest {

	 @Mock
	    GuestRepository guestRepo;
	    
	    @InjectMocks
	    GuestServiceImplementation GuestService;
	    
	    
	    Guest guest1;
	    Guest guest2;
	    List<Guest> GuestList;
	    
	    @BeforeEach
	    void setUp() {
	    	guest1=new Guest(1L,"demo",7010132952L,"demo@gmail.com","male","citius","banglore","doublebed","17-17-17","17-17-17",1000.00D);
	    	guest2=new Guest(2L,"demo",7010132952L,"demo@gmail.com","male","citius","banglore","doublebed","17-17-17","17-17-17",1000.00D);
	        GuestList=Arrays.asList(guest1,guest2);
	        
	    }



	   @Test
	    void testaddGuest() {

	       guestRepo.save(guest1);
	    }
	    

	   @Test
	    void testGuetAllBill() {
	        when(guestRepo.findAll()).thenReturn(GuestList);
	        List<Guest> guest=GuestService.getAllGuest();
	        assertEquals(GuestList,guest);
	    }



	   @Test
	    void testfetchGuestById() {
		   when(guestRepo.findById(1L)).thenReturn(Optional.of(guest1));
	        assertThat(GuestService.getGuestById(1L)).isEqualTo(guest1);
	    }
}

