package service;

import java.util.Collection;
import entity.Book;
import lombok.Setter;
import persistence.BookDao;

/**
 *
 * @author vic
 * date: 22/11/2022
 * purpose: Step 7. The SERVICE IMPLEMENTAION  (SERVICE LAYER - implementation)
 *
 */
public class BookServiceImpl implements BookService{

	//Instantiate a new object of the 'persistence' class - BookDao (the persistence interface):
	//import 'BookDao':
	//add a 'setter' for it:
	@Setter
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
