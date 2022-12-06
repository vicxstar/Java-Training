package com.vic.resource;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vic.entity.Employee;
import com.vic.entity.EmployeePayslip;
import com.vic.service.EmployeeService;

/**
 *
 * @author vic
 * date: 01/12/2022
 * purpose: The RESOURCE Class
 *
 */
//the '@RestController' annotation:
@RestController
public class EmployeeResource {

	@Autowired
	EmployeeService employeeService;
	
	//GET ALL EMPLOYEES:
	@RequestMapping(path = "/employees",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Employee> getAllEmployeesResource(){
		return employeeService.getAllEmployees();
	}
	
	//SEARCH EMPLOYEES BY ID:
	@RequestMapping(path = "/employees/{empId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee searchEmployeeByIdResource(@PathVariable("empId") int empId) {
		return employeeService.searchEmployeeById(empId);
	}
	
	//GENERATE EMPLOYEE PAYSLIP:
	@RequestMapping(path = "/employees/payslip/{empId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeePayslip generatePaySlipResource(@PathVariable("empId") int empId) {
		return employeeService.generatePaySlip(empId);
	}
	
	//SEARCH EMPLOYEES BY DEPARTMENT:
	@RequestMapping(path = "/employees/department/{department}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeesByDepartmentNameResource(@PathVariable("department") String dept) {
		return employeeService.getEmployeesByDepartmentName(dept);
	}
	
	//SEARCH EMPLOYEES BY ROLE:
	@RequestMapping(path = "/employees/role/{role}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	List<Employee> searchEmployeeByRoleResource(@PathVariable("role") String role){
		return employeeService.searchEmployeeByRole(role);
	}
	
	//GET EMPLOYEE SALARY:
	@RequestMapping(path = "/employees/salary/{salary}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	List<Employee> getEmpSalaryResource(@PathVariable("salary") double salary) {
		return employeeService.getEmpSalary(salary);
	}
	
	//ADD NEW EMPLOYEE:
	
	//REQUEST MAPPING:
//	@RequestMapping(path = "/employees", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	
	//POST MAPPING:
	@PostMapping(path = "/employees", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addEmployeeResource(@RequestBody Employee employee) {
		if( employeeService.addEmployee(employee))
			return "Record added";
		else
			return "Record not added";
	}
	
	//DELETE EMPLOYEE:
	
	//REQUEST MAPPING:
//	@RequestMapping(path = "/employees/{empId}", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
	
	//DELETE MAPPING:
	@DeleteMapping(path = "/employees/{empId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteEmployeeResource(@PathVariable("empId") int empId) {
		if(employeeService.deleteEmployee(empId))
			return "Employee Deleted";
		else
			return "Employee Not Deleted";
	}
	
	//INCREMENT SALARY:
	//REQUEST MAPPING:
//	@RequestMapping(path = "/employees/{empId}/{inc}", method = RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE)
	
	//GET MAPPING:
	@GetMapping(path = "/employees/{empId}/{inc}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String incrementSalary(@PathVariable("empId") int empId, @PathVariable("inc") double increment) {
		if(employeeService.incrementSalary(empId, increment))
			return "Salary Incremented";
		else
			return "Salary Not Incremented";	
	}
}
