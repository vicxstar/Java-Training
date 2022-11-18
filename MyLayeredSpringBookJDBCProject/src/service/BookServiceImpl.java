package service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Book;
import persistence.BookDao;
//import persistence.BookDaoImpl;

/**
 *
 * @author vic
 * date: 10/11/2022
 * purpose: Step 7. The SERVICE IMPLEMENTAION  (SERVICE LAYER - implementation)
 *
 */

//specify the component name:
//this allows Spring to automatically detect our custom beans:
@Component("service")
public class BookServiceImpl implements BookService{

	//Instantiate a new object of the 'persistence implementation' class - BookDaoImpl (which implements the persistence interface):
	//import 'BookDao' and 'BookDaoImpl':
//	private BookDao bookDao = new BookDaoImpl();

	//declare an 'BookDao' object:
	private BookDao bookDao;
	
	//generate a parameters constructor:
	//the '@Autowired' annotation is used to tell Spring which candidate it can use:
	public BookServiceImpl(@Autowired BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}
	
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
