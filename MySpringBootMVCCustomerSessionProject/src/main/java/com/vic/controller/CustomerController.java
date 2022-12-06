package com.vic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.vic.entity.Customer;
import com.vic.entity.CustomerBankBalance;
import com.vic.service.CustomerService;

/**
 *
 * @author vic
 * date: 30/11/2022
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
	
	//instantiate a 'ModelAndView' object:
	ModelAndView mav = new ModelAndView();
	
	
	//====================== LOGIN PAGE =======================
	
	//Mapping Handler - name it differently to it's method name:
	//import it
	@RequestMapping("/")
	//all controller methods must be public:
	public ModelAndView loginPageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file and a new 'User' object:
		return new ModelAndView("loginPage", "customer", new Customer());
	}
	
	//Mapping Handler - name it differently to it's method name:
	@RequestMapping("/login")
	//all controller methods must be public:
	//import '@ModelAttribute' to match the attributes:
	//import 'HttpSession' to start a session for the user:
	//import '@RequestParam'
	public ModelAndView loginController(@ModelAttribute("customer") Customer customer, HttpSession session) {
		
		//check if a user has inputed login credentials that match the database table:
		if(custService.loginCheck(customer)) {
			
			//setting data for viewing on view:
			mav.addObject("customer", customer);
			
			//set the session with the customer's name:
			session.setAttribute("customer", customer);
			
			//if the credentials match the database table, show 'index.html' (the homepage):
			mav.setViewName("index");
		}
		//if they inputed incorrect login credentials: 
		else {
			//tell the user:
			mav.addObject("message", "Invalid User Credentials. Please try again.");
			
			//setting data for viewing on view:
			mav.addObject("customer", new Customer());
			
			//return to the login page:
			mav.setViewName("loginPage");
		}
		
		//return the instantiated 'ModelAndView' object - 'mav'
		return mav;
	}
	
	
	//============================ HOMEPAGE ============================
	
	//Mapping Handler
	//import it
	@RequestMapping("/homepage")
	//all controller methods must be public:
	public ModelAndView menuPageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("index");
	}
	
	
	//====================== LIST ALL CUSTOMERS =========================
	//Mapping Handler
	@RequestMapping("/listAllPage")
	//all controller methods must be public:
	public ModelAndView getAllCustomersController() {
		
		//import 'Collections' and 'Customer'
		Collection<Customer> custList = custService.findAllCustomers();
		
		//setting data for viewing on view:
		mav.addObject("customers", custList);
		
		//retrieving the data for viewing on view:
		mav.setViewName("listAllCustomers");
		
		//return the instantiated 'ModelAndView' object - 'mav'
		return mav;
	}
	
	
	//=========================== SEACH CUSTOMER BY ID ===========================
	
	//THE PAGE:
	//Mapping Handler - name it differently to it's method name
	@RequestMapping("/searchCustByIdPage")
	//all controller methods must be public:
	public ModelAndView searchCustomerByIdPageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("searchCustByID");
	}
	
	//THE METHOD:
	//Mapping Handler - name it differently to it's page name
	@RequestMapping("/searchCustomerById")
	//all controller methods must be public:
	public ModelAndView searchEmployeeByIdController(HttpServletRequest request) {
		
		//get user input:
		//request.getParameter() will return String so convert it into an int:
		int accId = Integer.parseInt(request.getParameter("accountId"));
		
		//instantiate a new 'Customer' object and call the 'searchCustomersById(accId)' method (from serviceImpl):
		Customer customer = custService.searchCustomersById(accId);
		
		//check if the user has added an input:
		if(customer != null) {
			//setting data for viewing on view:
			mav.addObject("customers", customer);
			
			//retrieving the data for viewing on view:
			mav.setViewName("listAllCustomers");
		}
		else {
			//retrieving the data for viewing on view:
			mav.setViewName("output");
			
			//setting data for viewing on view:
			mav.addObject("message", "Customer with Account ID '" + accId + "' does not exist!");
		}
		//return the instantiated 'ModelAndView' object - 'mav'
		return mav;
	}
	
	
	//=========================== DELETE CUSTOMER ==================================
	
	//THE PAGE:
	//Mapping Handler - name it differently to it's method name
	@RequestMapping("/deleteCustPage")
	//all controller methods must be public:
	public ModelAndView deleteCustomerPageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("deleteCustById");
	}
	
	//THE METHOD:
	//Mapping Handler - name it differently to it's page name
	@RequestMapping("/deleteCustomer")
	//all controller methods must be public:
	//import 'HttpServletRequest':
	public ModelAndView deleteCustomerController(HttpServletRequest request) {
		
		//get user input:
		//request.getParameter() will return String so convert it into an int:
		int acctId = Integer.parseInt(request.getParameter("accountId"));
		
		//declare a null string to store the result of 'deleteEmployeeController':
		String message = null;
		
		//if the database has that Account ID:
		if(custService.deleteCustomer(acctId))
			//if it does, delete the customer with that ID and tell the user:
			message = "Customer with Account ID '" + acctId + "' has been deleted.";
		else
			//if it doesn't, tell the user:
			message = "Customer with Account ID '" + acctId + "' does not exist";
		
		//setting data for viewing on view:
		mav.addObject("message", message);
		
		//retrieving the data for viewing on view:
		mav.setViewName("output");
		
		//return the instantiated 'ModelAndView' object - 'mav'
		return mav;
	}
	
	//====================== INCREMENT BANK BALANCE =========================
	
	//THE PAGE:
	//Mapping Handler - name it differently to it's method name
	@RequestMapping("/incbalPage")
	//all controller methods must be public:
	public ModelAndView incremenBalancePageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("incrementBalance");
	}
		
	//THE METHOD:
	//Mapping Handler - name it differently to it's page name
	@RequestMapping("/incrementBalance")
	//all controller methods must be public:
	//import '@RequestParam'
	public ModelAndView incrementBalanceController(@RequestParam("rAccountId") int recepientAccountId, @RequestParam("amount") double balance, HttpSession session) {
		
		//get user input:
		//use 'session' to tell the server to use the logged in user's info to get required objects:
		int accId = ((Customer)session.getAttribute("customer")).getAccountId();
		
		//to transfer money:
		Customer customer = custService.transferMoney(recepientAccountId, accId, recepientAccountId);
		
		//check to see if the user has any funds:
		// if they do not:
		if(customer == null) {
			//tell the user the transaction failed:
			mav.addObject("message", "Transaction Failed.");
		
			//set the session with the user's name:
			session.setAttribute("customer", customer);
		}
		//if they do have funds:
		else
		//setting data for viewing on view:
		mav.addObject("message", "Your Account has been debited with balance " + balance + " and credited in Account Number '" + recepientAccountId + "'. Your current Balance is " + customer.getBankBalance());
		
		//retrieving the data for viewing on view:
		mav.setViewName("output");
		
		//return the instantiated 'ModelAndView' object - 'mav'
		return mav;
	}
	
	
	//===========================  GENERATE BANK BALANCE ===============================
	
	//THE PAGE:
	//Mapping Handler - name it differently to it's method name
	@RequestMapping("/genBalPage")
	//all controller methods must be public:
	public ModelAndView generatePayslipPageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("searchBal");
	}
		
	//THE METHOD:
	//Mapping Handler - name it differently to it's page name
	@RequestMapping("/generateBankBalance")
	//all controller methods must be public:
	public ModelAndView generatePayslipController(HttpServletRequest request) {
		
		//get user input:
		//request.getParameter() will return String so convert it into an int:
		//get user input:
		//request.getParameter() will return String so convert it into an int:
		int accId = Integer.parseInt(request.getParameter("accountId"));
		
		//instantiate a new 'CustomerBankBalance' object and call the 'generateBankBalace' method (from serviceImpl):
		//import the 'CustomerBankBalance' class:
		CustomerBankBalance balance = custService.generateBankBalace(accId);
		
		//check if the customer exists:
		if(balance != null) {
			//if it exists, show the balance:
			mav.addObject("balance", balance);
			
			//retrieving the data for viewing on view:
			mav.setViewName("generateBalance");
		}
		else {
			//if the customer does not exist, tell the user:
			mav.addObject("message", "Customer with Account ID '" + accId + "' does not exist!");
			
			//retrieving the data for viewing on view:
			mav.setViewName("output");
		}
		
		//return the instantiated 'ModelAndView' object - 'mav':
		return mav;
	}
}
