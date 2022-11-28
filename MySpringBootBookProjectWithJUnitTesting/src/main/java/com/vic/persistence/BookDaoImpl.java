/**
 * 
 */
package com.vic.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.vic.entity.Book;


/**
 *
 * @author vic
 * date: 24/11/2022
 * purpose: Step 6. DAO implementation (PERSISTENCE LAYER - implementation)
 *
 */
//'@Repository' indicates that this class is a 'repository' that can store and retrieve a collection of objects:
@Repository
public class BookDaoImpl implements BookDao {

	//the '@Autowired' annotation is used to tell Spring which candidate it can use:
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Override the methods from the DAO interface (menu system):
	@Override
	public Collection<Book> getAllBooks() {
		//the query string:
		String query = "SELECT * FROM BOOKS";
		
		//declare and instantiate a new 'EmployeeRowMapper' and use 'jdbcTemplate' to query it:
		//put the query results into a list (empList):
		List<Book> bookList = jdbcTemplate.query(query, new BookRowMapper());
		
		//return the list:
		return bookList;
	}

	@Override
	public Book searchBooks(int bookId) {
		//declare and instantiate a null 'Book' object:
		Book book = null;
		
		//a 'try-catch' statement:
		try {

			//the query string:
			String query = "SELECT * FROM BOOKS WHERE BOOKID = ?";
			
			//declare and instantiate a new 'BookRowMapper' and use 'jdbcTemplate' to query the id:
			//put the query results into the 'Book' object:
			book = jdbcTemplate.queryForObject(query, new BookRowMapper(), bookId);
		
		//the exception to catch:
		} catch (EmptyResultDataAccessException ex) {
			
			return null;
		}
		//return the 'Book' object:
		return book;
	}

	@Override
	public int insertBook(Book book) {
		
		String query = "INSERT INTO BOOKS VALUES(?,?,?,?)";
		
		int rows = jdbcTemplate.update(query, book.getBookId(), book.getBookName(), book.getAuthorName(), book.getNoOfCopies());
			
		//return 'rows':
		return rows;
	}

	@Override
	public int deleteBook(int bookId) {
		
		String query = "DELETE FROM BOOKS WHERE BOOKID = ?";
		
		int rows = jdbcTemplate.update(query, bookId);
			
		//return 'rows':
		return rows;
	}

	@Override
	public int incrementNoOfCopies(int id, int increment) {
		
		String query = "UPDATE BOOKS SET NOOFCOPIES = NOOFCOPIES + ? WHERE BOOKID = ?";
		
		int rows = jdbcTemplate.update(query, increment, id);
		
		//return the 'rows':
		return rows;
	}
}
