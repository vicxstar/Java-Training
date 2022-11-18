package Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Entity.Employee;
import Entity.EmployeePaySlip;
import Persistence.EmployeeDao;
import Persistence.EmployeeDaoImpl;

/**
 *
 * @author vic
 * date: 09/11/2022
 * purpose: Step 7. The SERVICE IMPLEMENTAION  (SERVICE LAYER - implementation)
 *
 */
public class EmployeeServiceImpl implements EmployeeService{

	//Instantiate a new object of the 'persistence implementation' class - EmployeeDaoImpl (which implements the persistence interface):
	//import 'EmployeeDao' and 'EmployeeDaoImpl':
	private EmployeeDao employeeDao=new EmployeeDaoImpl();

	//override the methods from the DTO (service layer) INTERFACE:
	@Override
	public Collection<Employee> getAllEmployees() {
		return employeeDao.getAllRecords();
	}

	@Override
	public Employee searchEmployeeById(int id) {
		return employeeDao.searchRecord(id);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if(employeeDao.insertRecord(employee) > 0) 
			return true;
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		if(employeeDao.deleteRecord(id) > 0)
			return true;
		return false;
	}

	@Override
	public boolean incrementSalary(int id, double increment) {
		if(employeeDao.updateSalary(id,increment)>0)
			return true;
		return false;
	}

	@Override
	public EmployeePaySlip generatePaySlip(int employeeId) {
		Employee employee=employeeDao.searchRecord(employeeId);
		if(employee!=null) {
			double allowanceA=.18*employee.getEmpSalary();
			double allowanceB=.12*employee.getEmpSalary();
			double deduction=.08*employee.getEmpSalary();
			double totalSalary=employee.getEmpSalary()+allowanceA+allowanceB-deduction;
			
			EmployeePaySlip employeePaySlip=new EmployeePaySlip(employee, allowanceA, allowanceB, deduction,totalSalary);
			return employeePaySlip;
		}
		return null;
	}

	@Override
	public Collection<Employee> searchEmployeeByDepartment(String department) {
		return employeeDao.employeeByDepartment(department);
	}
	
}
