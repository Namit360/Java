package com.spring.profile;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("csi")
@Profile("ComputerSci")
public class ComputerSci implements Department
{
	@Override
	public void runConfiguration() 
	{
		System.out.println("Department of ComputerScience");
	}
}