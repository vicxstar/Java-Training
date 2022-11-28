package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate; //better than using 'sql.date' or 'util.date'

import org.springframework.jdbc.core.RowMapper;

import Entity.Employee;

/**
 *
 * @author vic
 * date: 24/11/2022
 * purpose: The Row Mapper Class
 *
 */
//import 'RowMapper' and 'Employee'
public class EmployeeRowMapper implements RowMapper<Employee> {

	//override the 'RowMapper' methods:
	//DQL - declare a 'ResultSet' variable (rs):
	//DML - declare an int variable (rowNum):
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		int eid = rs.getInt("EMPLOYEEID");
		//read varchar type 'firstName' column from employee table:
		String firstName = rs.getString("FIRSTNAME");
		//read varchar type 'lastName' column from employee table:
        String lastName = rs.getString("LASTNAME");
        //read varchar type 'email' column from employee table:
        String email = rs.getString("EMAIL");
        //read varchar type 'phoneNumber' column from employee table:
        String phoneNumber = rs.getString("PHONENUMBER");
        //read date type 'hireDate' column from employee table:
        //import 'Date'
        LocalDate hireDate = rs.getDate("HIREDATE").toLocalDate();
        //read varchar type 'jobId' column from employee table:
        String jobId = rs.getString("JOBID");
        //read double type 'salary' column from employee table:
        double sal = rs.getDouble("SALARY");
        //read double type 'commission_pct' column from employee table:
        double commission = rs.getDouble("COMMISSION_PCT");
        //read int type 'managerId' column from employee table:
        int managerId = rs.getInt("MANAGERID");
        //read int type 'deptId' column from employee table:
        int deptId = rs.getInt("DEPARTMENTID");
        //read string type 'departmentName' column from employee table:
        String deptName = rs.getString("DEPARTMENTNAME");

		//declare and instantiate a new 'Employee' object and add the inputs to the 'Employee' object:
        Employee employee = new Employee(eid, firstName, lastName, email, phoneNumber, hireDate, jobId, sal, commission, 
				managerId, deptId, deptName);
				
		//return the 'Employee' object:
		return employee;
	}

}
