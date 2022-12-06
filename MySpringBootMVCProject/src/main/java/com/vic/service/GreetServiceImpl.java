package com.vic.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author vic
 * date: 29/11/2022
 * purpose: The Model Implementation
 *
 */
@Service
public class GreetServiceImpl implements GreetService {

	@Override
	public String goodMorning() {
		
		return "Good Morning Dear Visitor!";
	}

	@Override
	public String goodEvening() {
		
		return "Good Evening Dear Visitor!";
	}
	
	

}
