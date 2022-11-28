package service;

import java.util.Collection;

import entity.Book;

/**
 *
 * @author vic
 * date: 10/11/2022
 * purpose: Step 4. The DTO INTERFACE (SERVICE LAYER)
 *
 */
public interface BookService {

	//create the methods to make a call to the DAO to retrieve data from the database:
	//import 'Collection' and 'Book': 
	Collection<Book>getAllBooks();
	Book searchBooks(int bookId);
	boolean addBook(Book book);
	boolean deleteBook(int bookId);
}
