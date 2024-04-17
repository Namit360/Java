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

import com.Hotel.model.Bill;
import com.Hotel.repository.BillRepository;
@ExtendWith(SpringExtension.class)
class BillServiceImplementationTest {

	 @Mock
	    BillRepository billRepo;
	    
	    @InjectMocks
	    BillServiceImplementation BillService;
	    
	    
	    Bill bill1;
	    Bill bill2;
	    List<Bill> BillList;
	    
	    @BeforeEach
	    void setUp() {
	    	bill1=new Bill(1L,"vishal",101,1000.00D,500.00D,1500.00D,"Paid");
	        bill2=new Bill(2L,"supriya",102,1200.00D,500.00D,1700.00D,"Paid");
	        BillList=Arrays.asList(bill1,bill2);
	        
	    }



	   @Test
	    void testaddStaff() {

	       billRepo.save(bill1);
	    }
	    

	   @Test
	    void testfetchAllBill() {
	        when(billRepo.findAll()).thenReturn(BillList);
	        List<Bill> bill=BillService.getAllBill();
	        assertEquals(BillList,bill);
	    }



	   @Test
	    void testfetchStaffById() {
	        when(billRepo.findById(1L)).thenReturn(Optional.of(bill1));
	        assertThat(BillService.getBillById(1L)).isEqualTo(bill1);
	    }
}
