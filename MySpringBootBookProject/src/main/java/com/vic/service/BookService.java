/**
 * 
 */
package com.vic.service;

import java.util.Collection;

import com.vic.entity.Book;


/**
 *
 * @author vic
 * date: 24/11/2022
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
	boolean incrementNoOfCopies(int id, int increment);
}
