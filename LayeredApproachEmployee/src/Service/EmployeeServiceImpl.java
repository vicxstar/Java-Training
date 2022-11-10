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
		Employee emp=employeeDao.searchRecord(employee.getEmpId());
		if(emp!=null) {
			return false;
		}
		employeeDao.insertRecord(employee);
		return true;
	}

	@Override
	public boolean deleteEmployee(int id) {
		Employee employee=employeeDao.deleteRecord(id);
		if(employee!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean incrementSalary(int id, double increment) {
		Employee employee=employeeDao.searchRecord(id);
		if(employee==null) {
			return false;
		}
		employee.setEmpSalary(employee.getEmpSalary()+increment);
		employeeDao.insertRecord(employee);
		return true;
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
	public List<Employee> employeeByDepartment(String department) { 
		//create a collection (of type Employee) to store all employee records:
		Collection<Employee> employees = employeeDao.getAllRecords();
		
		//create a list (with type Employee) to store the departments into:
		List<Employee> empList = new ArrayList<Employee>();
		
		//an enhanced 'for' loop to add all the employees with an inputed department into the list:
		for(Employee emp: employees) {
			//check to see if the department exists:
			if(emp.getEmpDepartment().equals(department)) {
				//if it does then add the employee records into the list 'empList':
				empList.add(emp);
			}
			//check to see if the list does not equal 0 (input has been added):
			if(empList.size() != 0) {
				//if there has been input added, return the list:
				return empList;
			}
		}
		return null;
	}
	
	
	
}
