/**
 * 
 */
package com.vic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vic.entity.Book;
import com.vic.persistence.BookDao;


/**
 *
 * @author vic
 * date: 
 * purpose: 
 *
 */
//'@Service' indicates that this class has the business logic:
@Service
public class BookServiceImpl implements BookService {

	//Instantiate a new object of the 'persistence implementation' class - BookDaoImpl (which implements the persistence interface):
	//the '@Autowired' annotation is used to tell Spring which candidate it can use:
	//import 'BookDao' and '@Autowired':
	@Autowired
	private BookDao bookDao;
	
	//override the methods from the DTO (service layer) INTERFACE:
	@Override
	public Collection<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public Book searchBooks(int bookId) {
		return bookDao.searchBooks(bookId);
	}

	@Override
	public boolean addBook(Book book) {
		Book bk = bookDao.searchBooks(book.getBookId());
		if(bk != null) {
			return false;
		}
		bookDao.insertBook(book);
		return true;
	}

	@Override
	public boolean deleteBook(int bookId) {
		if((bookDao.deleteBook(bookId) > 0)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean incrementNoOfCopies(int id, int increment) {
		if(bookDao.incrementNoOfCopies(id, increment) > 0)
			return true; 
		return false;
	}
}