package Persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Entity.Employee;

/**
 *
 * @author vic
 * date: 23/11/2022
 * purpose: Step 6. DAO implementation (PERSISTENCE LAYER - implementation) 
 *
 */
//
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	//the '@Autowired' annotation is used to tell Spring which candidate it can use:
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Override the methods from the DAO interface (menu system):
	@Override
	public Collection<Employee> getAllRecords() {
		
		//the query string:
		String query = "SELECT * FROM EMPLOYEES";
		
		//declare and instantiate a new 'EmployeeRowMapper' and use 'jdbcTemplate' to query it:
		//put the query results into a list (empList):
		List<Employee> empList = jdbcTemplate.query(query, new EmployeeRowMapper());
		
		//return the list:
		return empList;
	}

	@Override
	public Employee searchRecord(int id) {
		//declare and instantiate a null 'Employee' object:
		Employee employee = null;
		
		//a 'try-catch' statement:
		try {

			//the query string:
			String query = "SELECT * FROM EMPLOYEES WHERE EMPLOYEEID = ?";
			
			//declare and instantiate a new 'EmployeeRowMapper' and use 'jdbcTemplate' to query the id:
			//put the query results into the 'Employee' object:
			employee = jdbcTemplate.queryForObject(query, new EmployeeRowMapper(), id);
		
		//the exception to catch:
		} catch (EmptyResultDataAccessException ex) {
			
			return null;
		}
		//return the 'Employee' object:
		return employee;
	}

	@Override
	public int insertRecord(Employee employee) {
		
		String query = "INSERT INTO EMPLOYEES VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int rows = jdbcTemplate.update(query, employee.getEmpId(), employee.getEmpFirstName(), employee.getEmpLastName(),
				employee.getEmpEmail(), employee.getEmpPhoneNum(), employee.getHireDate(), employee.getJobId(), employee.getEmpSalary(),
				employee.getEmpCommission(), employee.getManagerId(), employee.getDepartmentId(), employee.getDepartmentName());
			
		//return 'rows':
		return rows;
	}

	@Override
	public int deleteRecord(int id) {
		
		String query = "DELETE FROM EMPLOYEES WHERE EMPLOYEEID = ?";
		
		int rows = jdbcTemplate.update(query, id);
		
		//return the 'rows':
		return rows;
	}

	@Override
	public int updateSalary(int id, double increment) {
		
		String query = "UPDATE EMPLOYEE SET SALARY = SALARY + ? WHERE EMPLOYEEID = ?";
		
		int rows = jdbcTemplate.update(query, id);
		
		//return the 'rows':
		return rows;
	}

	@Override
	public Collection<Employee> employeeByDepartment(String department) {
		// TODO Auto-generated method stub
		return null;
	}
}
