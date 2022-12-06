/**
 * 
 */
package com.vic.controller;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.vic.entity.Employee;
import com.vic.entity.EmployeePayslip;
import com.vic.service.EmployeeService;

/**
 *
 * @author vic
 * date: 30/11/2022
 * purpose: The Controller Class
 *
 */
//'@Controller' is used to mark any class as controller:
//import it
@Controller
public class EmployeeController {

	//declare and instantiate a 'EmployeeService' object:
	@Autowired
	private EmployeeService empService;
	
	//instantiate a 'ModelAndView' object:
	ModelAndView mav= new ModelAndView();
	
	//====================== HOMEPAGE =======================
	
	//Mapping Handler
	//import it
	@RequestMapping("/")
	//all controller methods must be public:
	public ModelAndView menuPageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("index");
	}
	
	
	//====================== LIST ALL EMPLOYEES =========================
	//Mapping Handler
	@RequestMapping("/listAllPage")
	//all controller methods must be public:
	public ModelAndView getAllEmployeesController() {
		
		//import 'Collections' and 'Employee'
		Collection<Employee> empList = empService.getAllEmployees();
		
		//setting data for viewing on view:
		mav.addObject("employees", empList);
		
		//retrieving the data for viewing on view:
		mav.setViewName("listAllEmployees");
		
		//return the instantiated 'ModelAndView' object - 'mav'
		return mav;
	}
	
	
	//=========================== SEACH EMPLOYEE BY ID ===========================
	
	//THE PAGE:
	//Mapping Handler - name it differently to it's method name
	@RequestMapping("/searchEmpByIdPage")
	//all controller methods must be public:
	public ModelAndView searchEmployeeByIdPageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("searchEmpByID");
	}
	
	//THE METHOD:
	//Mapping Handler - name it differently to it's page name
	@RequestMapping("/searchEmployeeByID")
	//all controller methods must be public:
	public ModelAndView searchEmployeeByIdController(HttpServletRequest request) {
		
		//get user input:
		//request.getParameter() will return String so convert it into an int:
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		//instantiate a new 'Employee' object and call the 'searchEmployee(id)' method (from serviceImpl):
		Employee employee = empService.searchEmployeeById(empId);
		
		if(employee != null) {
			//setting data for viewing on view:
			mav.addObject("employees", employee);
			
			//retrieving the data for viewing on view:
			mav.setViewName("listAllEmployees");
		}
		else {
			//retrieving the data for viewing on view:
			mav.setViewName("output");
			
			//setting data for viewing on view:
			mav.addObject("message", "Employee with ID '" + empId + "' does not exist!");
		}
		//return the instantiated 'ModelAndView' object - 'mav'
		return mav;
	}
		
	//====================== SEARCH EMPLOYEE BY DEPARTMENT ========================
	
	//THE PAGE:
	//Mapping Handler - name it differently to it's method name
	@RequestMapping("/searchEmpByDeptPage")
	//all controller methods must be public:
	public ModelAndView seachEmployeeByDepartmentPageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("searchEmpByDept");
	}
	
	//THE METHOD:
	//Mapping Handler - name it differently to it's page name
	@RequestMapping("/searchEmployeeByDepartment")
	//all controller methods must be public:
	public ModelAndView searchEmployeeByDepartmentController(HttpServletRequest request) {
		
		//get user input:
		//request.getParameter() will return String so no need to convert it:
		String empDept = request.getParameter("department");
		
		//create a collection to store the employees that match the user's input:
		Collection<Employee> empList = empService.getEmployeesByDepartmentName(empDept);
		
		//create an 'if' statement to check if the department inputed exists:
		//if the department does exist print all the information:
		if(empList.size() > 0) {
			//setting data for viewing on view:
			mav.addObject("employees", empList);
			
			//retrieving the data for viewing on view:
			mav.setViewName("listAllEmployees");
		}
		//if the department does not exist, tell the user:
		else {
			//retrieving the data for viewing on view:
			mav.setViewName("output");
			
			//setting data for viewing on view:
			mav.addObject("message", "Department '" + empDept + "' does not exist!");
		}
		
		//return the instantiated 'ModelAndView' object - 'mav'
		return mav;
	}
	
	
	//=========================== ADD NEW EMPLOYEE =================================
	
	//THE PAGE:
	//Mapping Handler - name it differently to it's method name
	@RequestMapping("/addNewEmpPage")
	//all controller methods must be public:
	public ModelAndView addNewEmployeePageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("addNewEmp");
	}
	
	//THE METHOD:
	//Mapping Handler - name it differently to it's page name
	@RequestMapping("/addNewEmployee")
	//all controller methods must be public:
	public ModelAndView addNewEmployeeController(HttpServletRequest request) {
		
		//instantiate a new 'Employee' object
		Employee employee = new Employee();
		
		//get user input:
		int id = Integer.parseInt(request.getParameter("id"));
		employee.setEmpId(id);
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		employee.setDepartmentId(deptId);
		String deptN = request.getParameter("deptN");
		employee.setDepartmentName(deptN);
		double com = Double.parseDouble(request.getParameter("com"));
		employee.setEmpCommission(com);
		String email = request.getParameter("email");
		employee.setEmpEmail(email);
		String fName = request.getParameter("fName");
		employee.setEmpFirstName(fName);
		String lName = request.getParameter("lName");
		employee.setEmpLastName(lName);
		String num = request.getParameter("num");
		employee.setEmpPhoneNum(num);
		double sal = Double.parseDouble(request.getParameter("sal"));
		employee.setEmpSalary(sal);
		
		//import 'DateTimeFormatter' 
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-d");
		String hire = request.getParameter("hire");
		LocalDate hireDate = LocalDate.parse(hire, df);
		employee.setHireDate(hireDate);
		
		String jobId = request.getParameter("jobId");
		employee.setJobId(jobId);
		int manId = Integer.parseInt(request.getParameter("manId"));
		employee.setManagerId(manId);
		String role = request.getParameter("role");
		employee.setRole(role);
		
		//declare a null string to store the result of 'deleteEmployeeController':
		String message = null;
		
		//check if there is already an employee with the ID inputed by the user:
		//if not: call the 'addEmployee()' method (from serviceImpl) and add the 'Employee' object into the parameters:
		if(empService.addEmployee(employee))
			message = "Employee Record Added";
		else
			//if an employee has already been added, tell the user:
			message = "Employee with id '" + employee.getEmpId() + "' already exist, so cannot add it as a new employee!";
		
		//setting data for viewing on view:
		mav.addObject("message", message);
		
		//retrieving the data for viewing on view:
		mav.setViewName("output");
		
		//return the instantiated 'ModelAndView' object - 'mav'
		return mav;
	}
	
	//=========================== DELETE EMPLOYEE ==================================
	
	//THE PAGE:
	//Mapping Handler - name it differently to it's method name
	@RequestMapping("/deleteEmpPage")
	//all controller methods must be public:
	public ModelAndView deletePageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("deleteEmpById");
	}
	
	//THE METHOD:
	//Mapping Handler - name it differently to it's page name
	@RequestMapping("/deleteEmployee")
	//all controller methods must be public:
	//import 'HttpServletRequest':
	public ModelAndView deleteEmployeeController(HttpServletRequest request) {
		
		//get user input:
		//request.getParameter() will return String so convert it into an int:
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		//declare a null string to store the result of 'deleteEmployeeController':
		String message = null;
		
		//if the database has that employee ID:
		if(empService.deleteEmployee(empId))
			//if it does, delete the employee with that ID and tell the user:
			message = "Employee with '" + empId + "' has been deleted.";
		else
			//if it doesn't, tell the user:
			message = "Employee with ID '" + empId + "' does not exist";
		
		//setting data for viewing on view:
		mav.addObject("message", message);
		
		//retrieving the data for viewing on view:
		mav.setViewName("output");
		
		//return the instantiated 'ModelAndView' object - 'mav'
		return mav;
	}
	
	//====================== INCREMENT SALARY =========================
	
	//THE PAGE:
	//Mapping Handler - name it differently to it's method name
	@RequestMapping("/incSalPage")
	//all controller methods must be public:
	public ModelAndView incrementSalaryPageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("incrementSalary");
	}
		
	//THE METHOD:
	//Mapping Handler - name it differently to it's page name
	@RequestMapping("/incrementSalary")
	//all controller methods must be public:
	public ModelAndView incrementSalaryController(HttpServletRequest request) {
		
		//get user input:
		//request.getParameter() will return String so convert it into an int:
		int empId = Integer.parseInt(request.getParameter("empId"));
				
		//request.getParameter() will return String so convert it into an int:
		double increment = Double.parseDouble(request.getParameter("increment"));
		
		//declare a null string to store the result of 'incrementSalaryController':
		String message = null;
		
		//check to see if the employee id exists:
		// if it does, call the 'incrementSalary' method (from serviceImpl):
		if(empService.incrementSalary(empId, increment))
			message = "Employee with Id '" + empId + "' salary incremented by " + increment;
		else
			//if employee does not exist, tell the user:
			message = "Employee with ID '" + empId + "' does not exist";
		
		//setting data for viewing on view:
		mav.addObject("message", message);
		
		//retrieving the data for viewing on view:
		mav.setViewName("output");
		
		//return the instantiated 'ModelAndView' object - 'mav'
		return mav;
	}
	

	//===========================  GENERATE PAYSLIP ==============================
	//THE PAGE:
	//Mapping Handler - name it differently to it's method name
	@RequestMapping("/genPayPage")
	//all controller methods must be public:
	public ModelAndView generatePayslipPageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("searchPayslip");
	}
		
	//THE METHOD:
	//Mapping Handler - name it differently to it's page name
	@RequestMapping("/generatePayslip")
	//all controller methods must be public:
	public ModelAndView generatePayslipController(HttpServletRequest request) {
		
		//get user input:
		//request.getParameter() will return String so convert it into an int:
		//get user input:
		//request.getParameter() will return String so convert it into an int:
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		//instantiate a new 'EmployeePaySlip' object and call the ''generatePaySlip) method (from serviceImpl):
		//import the 'EmployeePaySlip' class:
		EmployeePayslip payslip = empService.generatePaySlip(empId);
		
		//check if the employee exists:
		if(payslip != null) {
			//if it exists, show the payslip:
			mav.addObject("payslip", payslip);
			//retrieving the data for viewing on view:
			mav.setViewName("generatePayslip");
		}
		else {
			//if the employee does not exist, tell the user:
			mav.addObject("message", "Employee with id '" + empId + "' does not exist!");
			//retrieving the data for viewing on view:
			mav.setViewName("output");
		}
		
		//return the instantiated 'ModelAndView' object - 'mav':
		return mav;
	}
	
	
	//===========================  SEARCH EMPLOYEE BY ROLE ============================
	
	//THE PAGE:
	//Mapping Handler - name it differently to it's method name
	@RequestMapping("/searchEmpByRolePage")
	//all controller methods must be public:
	public ModelAndView searchEmployeeByRoleInputPageController() {
		//instantiate a 'ModelAndView' object and return it with the HTML file:
		return new ModelAndView("searchEmpRole");
	}

	//THE METHOD:
	//Mapping Handler - name it differently to it's page name
	@RequestMapping("/searchEmployeeByRole")
	//all controller methods must be public:
	public ModelAndView searchEmployeesByRoleController(HttpServletRequest request) {
	
		//get user input:
		//request.getParameter() will return String so no need to convert it:
		String role = request.getParameter("role");
		
		//create a collection to store the employees that match the user's input:
		Collection<Employee> empRoleList = empService.searchEmployeeByRole(role);
		
		//check if the employee exists:
		if(empRoleList.size() != 0) {
			//if it exists, show the list of employees that work there:
			mav.addObject("employees", empRoleList);
			//retrieving the data for viewing on view:
			mav.setViewName("listAllEmployees");
		}
		//if the employee does not exist:
		else {
			//tell the user:
			mav.addObject("message", "There are no Employees who have the role '" + role + "'.");
			//retrieving the data for viewing on view:
			mav.setViewName("output");
		}
		
		//return the instantiated 'ModelAndView' object - 'mav':
		return mav;
	}
	
	
	
}
