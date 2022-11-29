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
 * purpose: 
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
			employeeDao.insertEmployee(employee.getEmpId(), employee.getEmpFirstName(), employee.getEmpLastName(),
					employee.getEmpEmail(),employee.getEmpPhoneNum(), employee.getHireDate(), employee.getJobId(), 
					employee.getEmpSalary(), employee.getEmpCommission(), employee.getManagerId(),employee.getDepartmentId(), 
					employee.getDepartmentName(), employee.getRole());
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
		return employeeDao.findByDepartmentName(deptt);
	}

	@Override
	public List<Employee> getEmpSalary(double salary) {
		return employeeDao.findByEmpSalary(salary);
	}
}
