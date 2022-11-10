package Service;

import java.util.Collection;
import java.util.List;

import Entity.Employee;
import Entity.EmployeePaySlip;

/**
 *
 * @author vic
 * date: 09/11/2022
 * purpose: Step 4. The DTO INTERFACE (SERVICE LAYER)
 *
 */
public interface EmployeeService {

	//create the methods to make a call to the DAO to retrieve data from the database:
	//import 'Collection', 'Employee' and 'EmployeePaySlip': 
	Collection<Employee> getAllEmployees();
	Employee searchEmployeeById(int id);
	boolean addEmployee(Employee employee);
	boolean deleteEmployee(int id);
	boolean incrementSalary(int id,double increment);
	EmployeePaySlip generatePaySlip(int employeeId);
	List<Employee> employeeByDepartment (String department);
}
