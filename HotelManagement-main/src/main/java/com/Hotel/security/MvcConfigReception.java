package com.Hotel.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigReception implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		
		  registry.addViewController("/bill").setViewName("mainPage");
		  registry.addViewController("/").setViewName("mainPage");
		 
		registry.addViewController("/login").setViewName("login");
	}

}