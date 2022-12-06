package com.vic.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vic.entity.Customer;
import com.vic.entity.CustomerReceipt;
import com.vic.entity.Product;
import com.vic.service.CustomerService;

/**
 *
 * @author vic
 * date: 04/12/2022
 * purpose: The Controller Class for the Customers
 *
 */
//'@Controller' is used to mark any class as controller:
//import it
@Controller
public class CustomerController {

	//declare and instantiate a 'CustomerService' object:
	@Autowired
	private CustomerService custService;
	
	//====================== LOGIN PAGE =====================
	
//	//Mapping Handler - name it differently to it's method name:
//	//import it
//	@RequestMapping("/")
//	//all controller methods must be public:
//	public ModelAndView loginPageController() {
//		//instantiate a 'ModelAndView' object and return it with the HTML file:
//		return new ModelAndView("login");
//	}
//	
//	//Mapping Handler - name it differently to it's method name:
//	@RequestMapping("/loginPage")
//	//all controller methods must be public:
//	//import '@ModelAttribute' to match the attributes:
//	//import 'HttpSession' to start a session for the user:
//	//import '@RequestParam'
//	public ModelAndView loginController(@RequestParam("custId") int custId, @RequestParam("password") String password,  HttpSession session) {
//		
//		//declare and instantiate a 'Customer' object and get the required input:
//		Customer customer = custService.loginCheck(custId, password);
//		
//		//check if a user has inputed login credentials that match the database table:
//		if(customer != null) {
//			
//			//if they have, add the customer object to MAV
//			mav.addObject("customer", customer);
//			
//			//set attribute in session with the customer's details:
//			session.setAttribute("customer", customer);
//			
//			//if the credentials match the database table, show 'homepage.html':
//			mav.setViewName("homepage");
//		}
//		//if they inputed incorrect login credentials:
//		else { 
//			//tell the user:
//			mav.addObject("message", "Invalid Login Credentials. Please try again.");
//			
//			//reset customer object for another login try:
//			mav.addObject("customer", new Customer());
//			
//			//return to the login page:
//			mav.setViewName("login");
//		}
//		//return the instantiated 'ModelAndView' object - 'mav'
//		return mav;
//	}
	
	//Mapping Handler - name it differently to it's method name:
	//import it
	@RequestMapping("/")
	//all controller methods must be public:
	public ModelAndView loginPageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file and a new 'User' object:
		return new ModelAndView("login", "customer", new Customer());
	}
	
	//Mapping Handler - name it differently to it's method name:
	@RequestMapping("/login")
	//all controller methods must be public:
	//import '@ModelAttribute' to match the attributes:
	//import 'HttpSession' to start a session for the user:
	//import '@RequestParam'
	public ModelAndView loginController(@ModelAttribute("customer") Customer customer, HttpSession session) {
		//instantiate a 'ModelAndView' object:
		ModelAndView mav = new ModelAndView();
		//check if a user has inputed login credentials that match the database table:
		if(custService.loginCheck(customer)) {
			
			//setting data for viewing on view:
			mav.addObject("customer", customer);
			
			//set the session with the customer's name:
			session.setAttribute("customer", customer);
			
			//if the credentials match the database table, show 'index.html' (the homepage):
			mav.setViewName("homepage");
		}
		//if they inputed incorrect login credentials: 
		else {
			//tell the user:
			mav.addObject("message", "Invalid User Credentials. Please try again.");
			
			//setting data for viewing on view:
			mav.addObject("customer", new Customer());
			
			//return to the login page:
			mav.setViewName("login");
		}
		
		//return the instantiated 'ModelAndView' object - 'mav'
		return mav;
	}
	
	
	//====================== HOMEPAGE =======================
	
	//Mapping Handler
	//import it
	@RequestMapping("/homepage")
	//all controller methods must be public:
	public ModelAndView homePageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("homepage");
	}
	
	
	//=============== LIST ALL PRODUCTS PAGE ================
	
	//Mapping Handler
	@RequestMapping("/listAllProductsPage")
	//all controller methods must be public:
	public ModelAndView getAllProductsController() {
		//instantiate a 'ModelAndView' object:
		ModelAndView mav = new ModelAndView();
		//import 'Collections' and 'Product':
		Collection<Product> prodList = custService.findAllProducts();
		
		//setting data for viewing on view:
		mav.addObject("products", prodList);
		
		//retrieving the data for viewing on view:
		mav.setViewName("listAllProducts");
		
		//return the instantiated 'ModelAndView' object - 'mav'
		return mav;
	}
	
	
	//=========== CUSTOMER PRODUCTS RECEIPT PAGE ============
	
	//THE PAGE:
	//Mapping Handler - name it differently to it's method name
	@RequestMapping("/buyProductsByIdPage")
	//all controller methods must be public:
	public ModelAndView buyProductByIdInputPageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("inputForBuyProduct");
	}
	
	//THE METHOD:
	//Mapping Handler - name it differently to it's page name:
	@RequestMapping("/buyProductById")
	//all controller methods must be public:
	//import 'HttpSession' to start a session for the user:
	public ModelAndView buyProductByIdController(HttpServletRequest request, HttpSession session) {
		//instantiate a 'ModelAndView' object:
		ModelAndView mav = new ModelAndView();
		//get user input:
		//get client input for product and quantity of product being bought:
		//request.getParameter() will return String so convert it into an int:
		int productId = Integer.parseInt(request.getParameter("productId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		//instantiate a new 'Customer' object and get customer ID of the currently logged in customer:
		Customer customerObj = (Customer)session.getAttribute("customer");
		
		//declare an integer variable to get the customer ID:
		int customerId = customerObj.getCustId();
		
		//instantiate a new 'CustomerReceipt' object to get the receipt object of the customer's product purchase:
		CustomerReceipt receipt = custService.customerProductReceipt(customerId, productId, quantity);
		
		//if the receipt object is not null:
		if(receipt != null) {
			//add the receipt object and success message to the 'ModelAndView' object:
			mav.addObject("receipt", receipt);
			
			//show the customer receipt page:
			mav.setViewName("receipt");
		}
		//if the receipt object is null:
		else {
			//tell the user:
			mav.addObject("message", "Failed to purchase product! Either your balance is too low or the product does not exist!");
			
			//show output:
			mav.setViewName("output");
		}
		//return the instantiated 'ModelAndView' object - 'mav':
		return mav;
	}
}