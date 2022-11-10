package Persistence;

import java.util.Collection;

import Database.EmployeeDataBase;
import Entity.Employee;

/**
 *
 * @author vic
 * date: 09/11/2022
 * purpose: Step 6. DAO implementation (PERSISTENCE LAYER - implementation) 
 *
 */
public class EmployeeDaoImpl implements EmployeeDao{

	//Override the methods from the DAO interface (menu system):
	@Override
	public Collection<Employee> getAllRecords() {
		//import 'EmployeeDataBase':
		return EmployeeDataBase.getEmployeeList().values();
	}

	@Override
	public Employee searchRecord(int id) {
		return EmployeeDataBase.getEmployeeList().get(id);
	}

	@Override
	public Employee insertRecord(Employee employee) {
		return EmployeeDataBase.getEmployeeList().put(employee.getEmpId(), employee);
	}

	@Override
	public Employee deleteRecord(int id) {
		return EmployeeDataBase.getEmployeeList().remove(id);
	}
}
