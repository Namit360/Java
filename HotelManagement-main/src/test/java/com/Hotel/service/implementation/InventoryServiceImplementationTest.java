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

import com.Hotel.model.Inventory;
import com.Hotel.repository.InventoryRepository;



@ExtendWith(SpringExtension.class)
class InventoryServiceImplementationTest {
    
    @Mock
    InventoryRepository InvnRepo;
    
    @InjectMocks
    InventoryServiceImplementation InvnService;
    
    
    Inventory inventory1;
    Inventory inventory2;
    List<Inventory> InvnList;
    
    @BeforeEach
    void setUp() {
        inventory1=new Inventory(1,100,100,100,100);
        inventory2=new Inventory(2,200,200,200,200);
        InvnList=Arrays.asList(inventory1,inventory2);
        
    }



   @Test
    void testaddStaff() {



       InvnRepo.save(inventory1);
    }
    
    



   
      @Test void testfetchAllStaff() {
      when(InvnRepo.findAll()).thenReturn(InvnList); List<Inventory>
      invn=InvnService.fetchAllInventories(); assertEquals(InvnList,invn); }
      
      @Test void testfetchStaffById() {
      when(InvnRepo.findById(1)).thenReturn(Optional.of(inventory1));
      assertThat(InvnService.fetchInventoryfById(1)).isEqualTo(inventory1); }
     




}
