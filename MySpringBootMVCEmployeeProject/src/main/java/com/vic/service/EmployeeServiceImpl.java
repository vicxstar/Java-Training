package com.vic.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.vic.entity.Employee;
import com.vic.entity.EmployeePayslip;
import com.vic.persistence.EmployeeDao;

/**
 *
 * @author vic
 * date: 28/11/2022
 * purpose: Step 7. The SERVICE IMPLEMENTAION  (SERVICE LAYER - implementation)
 *
 */
//'@Service' indicates that this class has the business logic:
@Service
public class EmployeeServiceImpl implements EmployeeService {

	//Instantiate a new object of the 'persistence implementation' class - BookDaoImpl (which implements the persistence interface):
	//the '@Autowired' annotation is used to tell Spring which candidate it can use:
	//import 'BookDao' and '@Autowired':
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Collection<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Employee searchEmployeeById(int id) {
		return employeeDao.findById(id).orElse(null);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		try{
			//method from the Dao:
			employeeDao.insertEmployee(employee.getEmpId(), employee.getDepartmentId(), employee.getDepartmentName(), employee.getEmpCommission(), 
					employee.getEmpEmail(), employee.getEmpFirstName(), employee.getEmpLastName(), employee.getEmpPhoneNum(), employee.getEmpSalary(),
					employee.getHireDate(), employee.getJobId(), employee.getManagerId(), employee.getRole());
			return true;
		}
		//import the sql catch:
		catch(SQLIntegrityConstraintViolationException ex) {
			return false;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(int id) {
		if (searchEmployeeById(id) != null) {
			employeeDao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean incrementSalary(int id, double increment) {
		//method from the Dao:
		return employeeDao.updateSalary(id, increment) > 0;
	}

	@Override
	public EmployeePayslip generatePaySlip(int employeeId) {
		Employee employee=searchEmployeeById(employeeId);
		if(employee!=null) {
			double allowanceA=.18*employee.getEmpSalary();
			double allowanceB=.12*employee.getEmpSalary();
			double deduction=.08*employee.getEmpSalary();
			double totalSalary=employee.getEmpSalary()+allowanceA+allowanceB-deduction;
			
			EmployeePayslip employeePaySlip=new EmployeePayslip(employee, allowanceA, allowanceB, deduction,totalSalary);
			return employeePaySlip;
		}
		return null;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentName(String deptt) {
		//method from the Dao:
		return employeeDao.findByDepartmentName(deptt);
	}

	@Override
	public List<Employee> getEmpSalary(double salary) {
		//method from the Dao:
		return employeeDao.findByEmpSalary(salary);
	}
	
	@Override
	public List<Employee> searchEmployeeByRole(String role) {
		//method from the Dao:
		return employeeDao.searchEmpByRole(role);
	}
}
