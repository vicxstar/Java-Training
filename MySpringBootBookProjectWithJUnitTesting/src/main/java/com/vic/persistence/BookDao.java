/**
 * 
 */
package com.vic.persistence;

import java.util.Collection;

import com.vic.entity.Book;

/**
 *
 * @author vic
 * date: 24/11/2022
 * purpose: Step 3. The DAO INTERFACE (PERSISTENCE LAYER)
 *
 */
public interface BookDao {

	//create the methods for the menu:
	//import 'collection' and 'Book':
	Collection<Book>getAllBooks(); 
	Book searchBooks(int bookId);
	int insertBook(Book book);
	int deleteBook(int bookId);
	int incrementNoOfCopies(int id, int increment);
}
