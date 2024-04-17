package com.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.profile.Department;

@SpringBootApplication
public class SpringbootProfilingApplication implements CommandLineRunner
{
	@Autowired
	Department dept;
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringbootProfilingApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception
	{
		dept.runConfiguration();
	}
}
