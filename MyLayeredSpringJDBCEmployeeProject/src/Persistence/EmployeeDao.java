package Persistence;

import java.util.Collection;

import Entity.Employee;

/**
 *
 * @author vic
 * date: 09/11/2022
 * purpose: Step 3. The DAO INTERFACE (PERSISTENCE LAYER)
 *
 */
public interface EmployeeDao {

	//create the methods for the menu:
	//import 'collection' and 'Employee':
	Collection<Employee> getAllRecords();
	Employee searchRecord(int id);
	int insertRecord(Employee employee);
	int deleteRecord(int id);
	int updateSalary(int id,double increment);
	Collection<Employee> employeeByDepartment(String department);
}
