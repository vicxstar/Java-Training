package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import entity.Book;

/**
 *
 * @author vic
 * date: 24/11/2022
 * purpose: The Row Mapper Class
 *
 */
//import 'RowMapper' and 'Book'
public class BookRowMapper implements RowMapper<Book> {

	//override the 'RowMapper' methods:
	//DQL - declare a 'ResultSet' variable (rs):
	//DML - declare an int variable (rowNum):
	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		//read int type 'bookId' column from the Books table:
		int id = rs.getInt("BOOKID");
		//read varchar type 'bookName' column from the Books table:
		String bookName = rs.getString("BOOKNAME");
		//read varchar type 'authurName' column from the Books table:
		String authorName = rs.getString("AUTHORNAME");
		//read int type 'noOfCopies' column from the Books table:
		int noOfCopies = rs.getInt("NOOFCOPIES");
		
		//declare and instantiate a new 'Book' object and add the inputs to the 'Book' object:
		Book book = new Book(id, bookName, authorName, noOfCopies);
		
		//return the 'Book' object:
		return book;
	}

}
