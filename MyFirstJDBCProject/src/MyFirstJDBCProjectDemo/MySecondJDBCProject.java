package MyFirstJDBCProjectDemo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Date;
import java.util.Scanner;
//import java.sql.Date;
/**
 *
 * @author vic
 * date: 17/11/2022
 * purpose: JDBC Main Class - Input
 *
 */
public class MySecondJDBCProject {

	public static void main(String[] args) {
		
		//declare a 'Connection' variable:
		//import it
		Connection connection=null;
		
		//declare a 'PreparedStatement' variable:
		//import it
		PreparedStatement preparedStatement;
		
		//declare and initialise the scanner:
		//import it:
		Scanner input = new Scanner(System.in);
		
		//a 'try-catch' statement:
		try {
			
			//1. Connect:
			
			//1.1 Register Driver:
			//get driver address from MySQL WOrkBench
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//1.2 Connect to the Database:
			//add the 'JBDC connection string', followed by the database name, username and password:
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/WileyDI001", "root", "fiveteen");
			
			//2. Query the database to insert:
			preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEES VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			//ask the user for input:
			System.out.println("Please enter the Employee ID: ");
			//set the index of the input to the index of the query:
			preparedStatement.setInt(1, input.nextInt());
			
			//ask the user for input:
			System.out.println("Please enter the Employee's first name: ");
			//set the index of the input to the index of the query:
			preparedStatement.setString(2, input.next());
			
			//ask the user for input:
			System.out.println("Please enter the Employee's last name: ");
			//set the index of the input to the index of the query:
			preparedStatement.setString(3, input.next());
			
			//ask the user for input:
			System.out.println("Please enter the Employee's email address: ");
			//set the index of the input to the index of the query:
			preparedStatement.setString(4, input.next());
			
			//ask the user for input:
			System.out.println("Please enter the Employee's phone number: ");
			//set the index of the input to the index of the query:
			preparedStatement.setString(5, input.next());
			
			//ask the user for input:
			System.out.println("Please enter the Employee's hire date: ");
			//set the index of the input to the index of the query:
			preparedStatement.setDate(6, Date.valueOf(input.next()));
			
			//ask the user for input:
			System.out.println("Please enter the Employee's job ID: ");
			//set the index of the input to the index of the query:
			preparedStatement.setString(7, input.next());
			
			//ask the user for input:
			System.out.println("Please enter the Employee's salary: ");
			//set the index of the input to the index of the query:
			preparedStatement.setDouble(8, input.nextDouble());
			
			//ask the user for input:
			System.out.println("Please enter the Employee's commission: ");
			//set the index of the input to the index of the query:
			preparedStatement.setDouble(9, input.nextDouble());
			
			//ask the user for input:
			System.out.println("Please enter the Employee's manager ID: ");
			//set the index of the input to the index of the query:
			preparedStatement.setInt(10, input.nextInt());
			
			//ask the user for input:
			System.out.println("Please enter the Employee's department ID: ");
			//set the index of the input to the index of the query:
			preparedStatement.setInt(11, input.nextInt());
			
			//ask the user for input:
			System.out.println("Please enter the Employee's department name: ");
			//set the index of the input to the index of the query:
			preparedStatement.setString(12, input.next());
			
			//DML - declare an int variable, and use the 'executeUpdate()' method to produce a result:
			int rows = preparedStatement.executeUpdate();
			
			//3. process the results:
	        if(rows > 0)
	        	System.out.println("Employee Added");
	        else
	        	System.out.println("Employee Not Added");

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
