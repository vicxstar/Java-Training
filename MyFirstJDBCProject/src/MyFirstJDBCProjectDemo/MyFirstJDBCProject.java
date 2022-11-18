package MyFirstJDBCProjectDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author vic
 * date: 17/11/2022
 * purpose: JDBC Main Class
 *
 */
public class MyFirstJDBCProject {

	public static void main(String[] args) {
		
		//declare a 'Connection' variable:
		//import it
		Connection connection=null;
		
		//declare a 'PreparedStatement' variable:
		//import it
		PreparedStatement preparedStatement;

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
	            Date hireDate = resultSet.getDate("HIREDATE");
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

	            //displaying result:
	            System.out.println(id+" "+firstName+" "+lastName+" "+email+" "+phoneNumber
	                    +" "+jobId+" "+sal+" "+commission+" "+ managerId+" "+deptId+" "+deptName);
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
	}

}
