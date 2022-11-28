package service;

import java.util.Collection;
import entity.Book;
import persistence.BookDao;
import persistence.BookDaoImpl;

/**
 *
 * @author vic
 * date: 10/11/2022
 * purpose: Step 7. The SERVICE IMPLEMENTAION  (SERVICE LAYER - implementation)
 *
 */

public class BookServiceImpl implements BookService{

	//Instantiate a new object of the 'persistence implementation' class - BookDaoImpl (which implements the persistence interface):
	//import 'BookDao' and 'BookDaoImpl':
	private BookDao bookDao = new BookDaoImpl();
	
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
		if(bookDao.insertBook(book) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBook(int bookId) {
		if(bookDao.deleteBook(bookId) > 0) {
			return true;
		}
		return false;
	}
}
