package com.Hotel.service.implementation;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.Hotel.model.Staff;
import com.Hotel.repository.StaffRepository;
@ExtendWith(SpringExtension.class)
class StaffServiceImplementationTest {



   @Mock
    StaffRepository staffRepo;
    
    @InjectMocks
    StaffServiceImplementation staffService;
    
    
    Staff staff1;
    Staff staff2;
    List<Staff> staffList;
    
    @BeforeEach
    void setUp() {
        staff1=new Staff(1,"abc","Pune",25,10000L,"abc@gmail.com");
        staff2=new Staff(2,"lmn","Mumbai",28,10000L,"lmn@gmail.com");
        staffList=Arrays.asList(staff1,staff2);
        
    }



   @Test
    void testaddStaff() {



       staffRepo.save(staff1);
    }
    
    
    



   @Test
    void testfetchAllStaff() {
        when(staffRepo.findAll()).thenReturn(staffList);
        List<Staff> staff=staffService.fetchAllStaff();
        assertEquals(staffList,staff);
    }



   @Test
    void testfetchStaffById() {
        when(staffRepo.findById(1)).thenReturn(Optional.of(staff1));
        assertThat(staffService.fetchStaffById(1)).isEqualTo(staff1);
    }



}
