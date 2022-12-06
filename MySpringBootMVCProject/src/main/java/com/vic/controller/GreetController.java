package com.vic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vic.service.GreetService;

/**
 *
 * @author vic
 * date: 29/11/2022
 * purpose: The Controller Class
 *
 */
//'@Controller' is used to mark any class as controller:
//import it
@Controller
public class GreetController {

	@Autowired
	private GreetService greetService;
	
	//instantiate a 'ModelAndView' object:
	ModelAndView mav = new ModelAndView();
	
	//Mapping Handler
	//import it
	@RequestMapping("/morning")
	//all controller methods must be public:
	public ModelAndView myFirstController() {
		
		String greetMessage = greetService.goodMorning();
		
		//setting data for viewing on view:
		mav.addObject("message", greetMessage);
		
		//setting view name with is supposed to display output to the client:
		mav.setViewName("Greet");
		
		//return it:
		return mav;
	}
	
	//Mapping Handler
	@RequestMapping("/evening")
	//all controller methods must be public:
	public ModelAndView mySecondController() {
		
		mav = new ModelAndView();
		
		String leaveMessage = greetService.goodEvening();
		
		//setting data for viewing on view:
		mav.addObject("lMessage", leaveMessage);
		
		//setting view name with is supposed to display output to the client:
		mav.setViewName("EveGreet");
		
		//return it:
		return mav;
	}
}
