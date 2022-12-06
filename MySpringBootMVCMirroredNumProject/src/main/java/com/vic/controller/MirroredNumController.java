package com.vic.controller;

import javax.servlet.http.HttpServletRequest;

//import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.vic.service.MirroredNumService;

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
public class MirroredNumController {
	
	//declare and instantiate a 'MirroredNumService' object:
	@Autowired
	private MirroredNumService mirroredNumService;

	//Mapping Handler
	//import it
	@RequestMapping("/")
	//all controller methods must be public:
	public ModelAndView mainPageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("index");
	}
	
	//Mapping Handler
	@RequestMapping("/mirroredNumber")
	//all controller methods must be public:
	//import 'HttpServletRequest':
	public ModelAndView getMirroredNumber(HttpServletRequest request) {
		//instantiate a 'ModelAndView' object:
		ModelAndView mav = new ModelAndView();
		
		//request.getParameter() will return String so convert it into an int:
		int num = Integer.parseInt(request.getParameter("number"));
		
		//declare a null string to store the result of the mirrored num calculation:
		String result = null;
		
		//if the inputed number is a mirrored number:
		if(mirroredNumService.getMirrored(num))
			//tell the user:
			result = num + " is a Palindrome";
		
		//if it is not:
		else 
			//tell the user
			result = num + " is not a Palindrome";
		
		//setting data for viewing on view:
		mav.addObject("result", result);
		
		//retrieving the data for viewing on view:
		mav.setViewName("output");
		
		//return it:
		return mav;
	}
}
