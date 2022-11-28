package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate; //better than using 'sql.date' or 'util.date'
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

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
		//declare a 'Connection' variable:
		//import it
		Connection connection=null;
		
		//declare a 'PreparedStatement' variable:
		//import it
		PreparedStatement preparedStatement;
		
		//import 'Collections' and 'Employee':
		Collection<Employee> employeeList = new ArrayList<Employee>();
		
		//a 'try-catch' statement:
		try {
			
			//1. Connect:
			
			//1.1 Register Driver:
			//get driver address from MySQL WOrkBench
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//1.2 Connect to the Database:
			//add the 'JBDC connection string', followed by the database name, username and password:
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/WileyDI001", "root", "fiveteen");
			
			//2. Query the database:
			preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEES");
			
			//DQL - declare a 'ResultSet' variable, and use the 'executeQuery()' method to produce a result:
			ResultSet resultSet = preparedStatement.executeQuery();
			
			//3. process the results:
			while(resultSet.next()) {
				//read int type 'employeeid' column from employee table:
				int id = resultSet.getInt("EMPLOYEEID");
				//read varchar type 'firstName' column from employee table:
				String firstName = resultSet.getString("FIRSTNAME");
				//read varchar type 'lastName' column from employee table:
	            String lastName = resultSet.getString("LASTNAME");
	            //read varchar type 'email' column from employee table:
	            String email = resultSet.getString("EMAIL");
	            //read varchar type 'phoneNumber' column from employee table:
	            String phoneNumber = resultSet.getString("PHONENUMBER");
	            //read date type 'hireDate' column from employee table:
	            //import 'Date'
	            LocalDate hireDate = resultSet.getDate("HIREDATE").toLocalDate();
	            //read varchar type 'jobId' column from employee table:
	            String jobId = resultSet.getString("JOBID");
	            //read double type 'salary' column from employee table:
	            double sal = resultSet.getDouble("SALARY");
	            //read double type 'commission_pct' column from employee table:
	            double commission = resultSet.getDouble("COMMISSION_PCT");
	            //read int type 'managerId' column from employee table:
	            int managerId = resultSet.getInt("MANAGERID");
	            //read int type 'deptId' column from employee table:
	            int deptId = resultSet.getInt("DEPARTMENTID");
	            //read string type 'departmentName' column from employee table:
	            String deptName = resultSet.getString("DEPARTMENTNAME");
	            
	            //add the inputs to the 'employeeList' list:
	            employeeList.add(new Employee(id, firstName, lastName, email, phoneNumber, hireDate, jobId, sal, commission, 
	            				managerId, deptId, deptName));
			}
		} catch (ClassNotFoundException e) {
			//displaying the complete stack for exceptions
			e.printStackTrace();
		}
		//import 'SQLException'
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//4. Close the database connection:
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//return the 'employeeList' list:
		return employeeList;
	}

	@Override
	public Employee searchRecord(int id) {
		//declare a 'Connection' variable:
		//import it
		Connection connection=null;
		
		//declare a 'PreparedStatement' variable:
		//import it
		PreparedStatement preparedStatement;
		
		//declare and instantiate an 'Employee' object and make it equal 'null':
		Employee employee = null;
		
		//a 'try-catch' statement:
		try {
			
			//1. Connect:
			
			//1.1 Register Driver:
			//get driver address from MySQL WOrkBench
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//1.2 Connect to the Database:
			//add the 'JBDC connection string', followed by the database name, username and password:
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/WileyDI001", "root", "fiveteen");
			
			//2. Query the database:
			preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMPLOYEEID = ?");
			//set the index of the input to the index of the query:
			preparedStatement.setInt(1, id);
			
			//DQL - declare a 'ResultSet' variable, and use the 'executeQuery()' method to produce a result:
			ResultSet resultSet = preparedStatement.executeQuery();
			
			//3. process the results:
			while(resultSet.next()) {
				//read int type 'employeeid' column from employee table:
				int eid = resultSet.getInt("EMPLOYEEID");
				//read varchar type 'firstName' column from employee table:
				String firstName = resultSet.getString("FIRSTNAME");
				//read varchar type 'lastName' column from employee table:
	            String lastName = resultSet.getString("LASTNAME");
	            //read varchar type 'email' column from employee table:
	            String email = resultSet.getString("EMAIL");
	            //read varchar type 'phoneNumber' column from employee table:
	            String phoneNumber = resultSet.getString("PHONENUMBER");
	            //read date type 'hireDate' column from employee table:
	            //import 'Date'
	            LocalDate hireDate = resultSet.getDate("HIREDATE").toLocalDate();
	            //read varchar type 'jobId' column from employee table:
	            String jobId = resultSet.getString("JOBID");
	            //read double type 'salary' column from employee table:
	            double sal = resultSet.getDouble("SALARY");
	            //read double type 'commission_pct' column from employee table:
	            double commission = resultSet.getDouble("COMMISSION_PCT");
	            //read int type 'managerId' column from employee table:
	            int managerId = resultSet.getInt("MANAGERID");
	            //read int type 'deptId' column from employee table:
	            int deptId = resultSet.getInt("DEPARTMENTID");
	            //read string type 'departmentName' column from employee table:
	            String deptName = resultSet.getString("DEPARTMENTNAME");
	            
	            //add the inputs to the 'Employee' object:
	            employee = new Employee(eid, firstName, lastName, email, phoneNumber, hireDate, jobId, sal, commission, 
	            				managerId, deptId, deptName);
			}
		} catch (ClassNotFoundException e) {
			//displaying the complete stack for exceptions
			e.printStackTrace();
		}
		//import 'SQLException'
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//4. Close the database connection:
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//return the 'Employee' object:
		return employee;
	}

	@Override
	public int insertRecord(Employee employee) {
		//declare a 'Connection' variable:
		//import it
		Connection connection=null;
		
		//declare a 'PreparedStatement' variable:
		//import it
		PreparedStatement preparedStatement;
		
		//DML - declare an int variable, and use the 'executeUpdate()' method to produce a result:
		int rows = 0;
		
		//a 'try-catch' statement:
		try {
			//1. Connect:
			
			//1.1 Register Driver:
			//get driver address from MySQL WOrkBench
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//1.2 Connect to the Database:
			//add the 'JBDC connection string', followed by the database name, username and password:
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/WileyDI001", "root", "fiveteen");
		
			//2. Query the database:
			preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEES VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			//set the index of the input to the index of the query:
			preparedStatement.setInt(1, employee.getEmpId());
			//set the index of the input to the index of the query:
			preparedStatement.setString(2, employee.getEmpFirstName());
			//set the index of the input to the index of the query:
			preparedStatement.setString(3, employee.getEmpLastName());
			//set the index of the input to the index of the query:
			preparedStatement.setString(4, employee.getEmpEmail());
			//set the index of the input to the index of the query:
			preparedStatement.setString(5, employee.getEmpPhoneNum());
			//set the index of the input to the index of the query:
			preparedStatement.setObject(6,employee.getHireDate());
			//set the index of the input to the index of the query:
			preparedStatement.setString(7, employee.getJobId());
			//set the index of the input to the index of the query:
			preparedStatement.setDouble(8, employee.getEmpSalary());
			//set the index of the input to the index of the query:
			preparedStatement.setDouble(9, employee.getEmpCommission());
			//set the index of the input to the index of the query:
			preparedStatement.setInt(10, employee.getManagerId());
			//set the index of the input to the index of the query:
			preparedStatement.setInt(11, employee.getDepartmentId());
			//set the index of the input to the index of the query:
			preparedStatement.setString(12, employee.getDepartmentName());
			
			//DML - declare an int variable, and use the 'executeUpdate()' method to produce a result:
			rows = preparedStatement.executeUpdate();
			
			//return 'rows':
			return rows;
			
		} catch (ClassNotFoundException e) {
			//displaying the complete stack for exceptions
			e.printStackTrace();
		}
		//import 'SQLException'
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//4. Close the database connection:
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//return 'rows':
		return rows;
	}

	@Override
	public int deleteRecord(int id) {
		//declare a 'Connection' variable:
		//import it
		Connection connection=null;
		
		//declare a 'PreparedStatement' variable:
		//import it
		PreparedStatement preparedStatement;
		
		//DML - declare an int variable, and use the 'executeUpdate()' method to produce a result:
		int rows = 0;
		
		//a 'try-catch' statement:
		try {
			//1. Connect:
			
			//1.1 Register Driver:
			//get driver address from MySQL WOrkBench
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//1.2 Connect to the Database:
			//add the 'JBDC connection string', followed by the database name, username and password:
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/WileyDI001", "root", "fiveteen");
			
			//2. Query the database:
			preparedStatement = connection.prepareStatement("DELETE FROM EMPLOYEES WHERE EMPLOYEEID = ?");
			//set the index of the input to the index of the query:
			preparedStatement.setInt(1, id);
			
			//DML - declare an int variable, and use the 'executeUpdate()' method to produce a result:
			rows = preparedStatement.executeUpdate();
			
			//return 'rows':
			return rows;
			
		} catch (ClassNotFoundException e) {
			//displaying the complete stack for exceptions
			e.printStackTrace();
		}
		//import 'SQLException'
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//4. Close the database connection:
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//return the 'rows':
		return rows;
	}

	@Override
	public int updateSalary(int id, double increment) {
		//declare a 'Connection' variable:
		//import it
		Connection connection=null;
		
		//declare a 'PreparedStatement' variable:
		//import it
		PreparedStatement preparedStatement;
		
		//DML - declare an int variable, and use the 'executeUpdate()' method to produce a result:
		int rows = 0;
		
		//a 'try-catch' statement:
		try {
			//1. Connect:
			
			//1.1 Register Driver:
			//get driver address from MySQL WOrkBench
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//1.2 Connect to the Database:
			//add the 'JBDC connection string', followed by the database name, username and password:
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/WileyDI001", "root", "fiveteen");
			
			//2. Query the database:
			preparedStatement = connection.prepareStatement("UPDATE EMPLOYEE SET SALARY = SALARY + ? WHERE EMPLOYEEID = ?");
			//set the index of the input to the index of the query:
			preparedStatement.setDouble(1, increment);
			preparedStatement.setInt(2, id);
			
			//DML - declare an int variable, and use the 'executeUpdate()' method to produce a result:
			rows = preparedStatement.executeUpdate();
			
			//return 'rows':
			return rows;
			
		} catch (ClassNotFoundException e) {
			//displaying the complete stack for exceptions
			e.printStackTrace();
		}
		//import 'SQLException'
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//4. Close the database connection:
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//return the 'rows':
		return rows;
	}

	@Override
	public Collection<Employee> employeeByDepartment(String department) {
		//declare a 'Connection' variable:
		//import it
		Connection connection=null;
		
		//declare a 'PreparedStatement' variable:
		//import it
		PreparedStatement preparedStatement;
		
//		declare and instantiate an 'Employee' object and make it equal 'null':
//		Employee employee = null;
		
		//import 'Collections' and 'Employee':
		Collection<Employee> employeeList = new ArrayList<Employee>();
		
		//a 'try-catch' statement:
		try {
			
			//1. Connect:
			
			//1.1 Register Driver:
			//get driver address from MySQL WOrkBench
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//1.2 Connect to the Database:
			//add the 'JBDC connection string', followed by the database name, username and password:
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/WileyDI001", "root", "fiveteen");
			
			//2. Query the database:
			preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEES WHERE DEPARTMENTNAME = ?");
			//set the index of the input to the index of the query:
			preparedStatement.setString(1, department);
			
			//DQL - declare a 'ResultSet' variable, and use the 'executeQuery()' method to produce a result:
			ResultSet resultSet = preparedStatement.executeQuery();
			
			//3. process the results:
			while(resultSet.next()) {
				//read int type 'employeeid' column from employee table:
				int eid = resultSet.getInt("EMPLOYEEID");
				//read varchar type 'firstName' column from employee table:
				String firstName = resultSet.getString("FIRSTNAME");
				//read varchar type 'lastName' column from employee table:
	            String lastName = resultSet.getString("LASTNAME");
	            //read varchar type 'email' column from employee table:
	            String email = resultSet.getString("EMAIL");
	            //read varchar type 'phoneNumber' column from employee table:
	            String phoneNumber = resultSet.getString("PHONENUMBER");
	            //read date type 'hireDate' column from employee table:
	            //import 'Date'
	            LocalDate hireDate = resultSet.getDate("HIREDATE").toLocalDate();
	            //read varchar type 'jobId' column from employee table:
	            String jobId = resultSet.getString("JOBID");
	            //read double type 'salary' column from employee table:
	            double sal = resultSet.getDouble("SALARY");
	            //read double type 'commission_pct' column from employee table:
	            double commission = resultSet.getDouble("COMMISSION_PCT");
	            //read int type 'managerId' column from employee table:
	            int managerId = resultSet.getInt("MANAGERID");
	            //read int type 'deptId' column from employee table:
	            int deptId = resultSet.getInt("DEPARTMENTID");
	            //read string type 'departmentName' column from employee table:
	            String deptName = resultSet.getString("DEPARTMENTNAME");
	            
	            //add the inputs to the 'Employee' object:
	            employeeList.add(new Employee(eid, firstName, lastName, email, phoneNumber, hireDate, jobId, sal, commission, 
	            				managerId, deptId, deptName));
			}
		} catch (ClassNotFoundException e) {
			//displaying the complete stack for exceptions
			e.printStackTrace();
		}
		//import 'SQLException'
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//4. Close the database connection:
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//return the 'employeeList' object:
		return employeeList;
	}
}
