/**
 * 
 */
package com.vic.service;

import java.util.Collection;
import java.util.List;

import com.vic.entity.Employee;
import com.vic.entity.EmployeePayslip;

/**
 *
 * @author vic
 * date: 28/11/2022
 * purpose: Step 4. The DTO INTERFACE (SERVICE LAYER)
 *
 */
public interface EmployeeService {

	//create the methods to make a call to the DAO to retrieve data from the database:
	//import 'Collection', 'Employee' and 'EmployeePayslip':
	Collection<Employee> getAllEmployees();
	Employee searchEmployeeById(int id);
	boolean addEmployee(Employee employee);
	boolean deleteEmployee(int id);
	boolean incrementSalary(int id,double increment);
	EmployeePayslip generatePaySlip(int employeeId);
	List<Employee> getEmployeesByDepartmentName(String deptt);
	List<Employee> getEmpSalary(double salary);
}
