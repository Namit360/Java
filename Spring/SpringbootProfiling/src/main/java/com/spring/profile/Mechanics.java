package com.spring.profile;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("mech")
@Profile("Mechanics")
public class Mechanics implements Department
{
	@Override
	public void runConfiguration() 
	{
		System.out.println("Department of Mechanics");
	}
}