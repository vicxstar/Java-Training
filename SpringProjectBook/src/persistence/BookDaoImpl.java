package persistence;

import java.util.Collection;

import database.BookDataBase;
import entity.Book;

/**
 *
 * @author vic
 * date: 10/11/2022
 * purpose: Step 6. DAO implementation (PERSISTENCE LAYER - implementation) 
 *
 */
public class BookDaoImpl implements BookDao{

	//Override the methods from the DAO interface (menu system):
	@Override
	public Collection<Book> getAllBooks() {
		//import 'BookDataBase':
		return BookDataBase.getBookList().values();
	}

	@Override
	public Book searchBooks(int bookId) {
		return BookDataBase.getBookList().get(bookId);
	}

	@Override
	public Book insertBook(Book book) {
		return BookDataBase.getBookList().put(book.getBookId(), book);
	}

	@Override
	public Book deleteBook(int bookId) {
		return BookDataBase.getBookList().remove(bookId);
	}

}
