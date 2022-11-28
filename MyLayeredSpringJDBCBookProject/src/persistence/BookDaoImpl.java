package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import entity.Book;

/**
 *
 * @author vic
 * date: 10/11/2022
 * purpose: Step 6. DAO implementation (PERSISTENCE LAYER - implementation) 
 *
 */

//specify the component name:
//this allows Spring to automatically detect our custom beans:
@Component("dao")
public class BookDaoImpl implements BookDao{

	//Override the methods from the DAO interface (menu system):
	@Override
	public Collection<Book> getAllBooks() {
		//declare a 'Connection' variable:
		//import it
		Connection connection=null;
		
		//declare a 'PreparedStatement' variable:
		//import it
		PreparedStatement preparedStatement;
		
		//import 'Collections' and 'Book':
		Collection<Book> bookList = new ArrayList<Book>();
		
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
			preparedStatement = connection.prepareStatement("SELECT * FROM BOOKS");
			
			//DQL - declare a 'ResultSet' variable, and use the 'executeQuery()' method to produce a result:
			ResultSet resultSet = preparedStatement.executeQuery();
			
			//3. process the results:
			while(resultSet.next()) {
			//read int type 'bookId' column from the Books table:
			int id = resultSet.getInt("BOOKID");
			//read varchar type 'bookName' column from the Books table:
			String bookName = resultSet.getString("BOOKNAME");
			//read varchar type 'authurName' column from the Books table:
			String authorName = resultSet.getString("AUTHORNAME");
			//read int type 'noOfCopies' column from the Books table:
			int noOfCopies = resultSet.getInt("NOOFCOPIES");
			
			//add the inputs to the 'bookList' list:
			bookList.add(new Book(id, bookName,authorName, noOfCopies));
				
			} 
		}catch (ClassNotFoundException e) {
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
		//return the 'bookLiist' list:
		return bookList;
	}

	@Override
	public Book searchBooks(int bookId) {
		//declare a 'Connection' variable:
		//import it
		Connection connection=null;
		
		//declare a 'PreparedStatement' variable:
		//import it
		PreparedStatement preparedStatement;
		
		//declare and instantiate an 'Employee' object and make it equal 'null':
		Book book = null;
		
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
			preparedStatement = connection.prepareStatement("SELECT * FROM BOOKS WHERE BOOKID = ?");
			//set the index of the input to the index of the query:
			preparedStatement.setInt(1, bookId);
			
			//DQL - declare a 'ResultSet' variable, and use the 'executeQuery()' method to produce a result:
			ResultSet resultSet = preparedStatement.executeQuery();
			
			//3. process the results:
			while(resultSet.next()) {
			//read int type 'bookId' column from the Books table:
			int id = resultSet.getInt("BOOKID");
			//read varchar type 'bookName' column from the Books table:
			String bookName = resultSet.getString("BOOKNAME");
			//read varchar type 'authurName' column from the Books table:
			String authorName = resultSet.getString("AUTHORNAME");
			//read int type 'noOfCopies' column from the Books table:
			int noOfCopies = resultSet.getInt("NOOFCOPIES");
			
			//add the inputs to the 'Book' object:
			book = new Book(id, bookName, authorName, noOfCopies);
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
		//return the 'Book' object:
		return book;
	}

	@Override
	public int insertBook(Book book) {
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
			preparedStatement = connection.prepareStatement("INSERT INTO BOOKS VALUES(?,?,?,?)");
			//set the index of the input to the index of the query:
			preparedStatement.setInt(1,  book.getBookId());
			//set the index of the input to the index of the query:
			preparedStatement.setString(2, book.getBookName());
			//set the index of the input to the index of the query:
			preparedStatement.setString(3, book.getAuthorName());
			preparedStatement.setInt(4, book.getNoOfCopies());
			
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
		//the 'finally' statement:	
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
	public int deleteBook(int bookId) {
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
			preparedStatement = connection.prepareStatement("DELETE FROM BOOKS WHERE BOOKID = ?");
			//set the index of the input to the index of the query:
			preparedStatement.setInt(1, bookId);
			
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
		//the 'finally' statement:	
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
}
