package com.spring.model.service;
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
import com.spring.model.Owner;
import com.spring.repository.OwnerRepo;

@ExtendWith(SpringExtension.class)
class OwnerServicesImplTest 
{
	@Mock
	OwnerRepo ownerRepo;
	
	@InjectMocks
	OwnerServicesImpl ownerserviceimplementation;
	
	Owner owner1;
	Owner owner2;
	List<Owner> ownerlist;
	
	@BeforeEach
	void setup()
	{
		owner1 = new Owner(1,"Room Service",12,"Mohan",123);
		owner2 = new Owner(2,"Kitchen",11,"Jian",82);
		ownerlist = Arrays.asList(owner1,owner2);
	}
	
	 @Test
	 public void testAddDept()
	 {
		 ownerRepo.save(owner1);
	 }	
	 
	 @Test
	 public void testFetchDept()
	 {
	   when(ownerRepo.findAll()).thenReturn(ownerlist);
	   List<Owner> ownerlist =ownerserviceimplementation.fetchAlldept();
	   assertEquals(ownerlist,ownerlist);
	 }
	 
	 @Test
	 public void testFetchDeptById()
	 {
	   when(ownerRepo.findById(12)).thenReturn(Optional.of(owner1));
	   assertThat( ownerserviceimplementation.fetchDeptDetailsbyId(12).get()).isEqualTo(owner1);
	 }
}