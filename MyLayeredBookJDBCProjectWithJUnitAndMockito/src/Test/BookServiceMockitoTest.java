/**
 * 
 */
package Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import entity.Book;
import persistence.BookDao;
import service.BookServiceImpl;

/**
 *
 * @author vic
 * date: 21/11/2022
 * purpose: The BookService Mockito Testing Class
 *
 */
//can use '@DisplayName()' to name the test sequences:
@DisplayName("Testing BookService with Mockito")
class BookServiceMockitoTest {

	//declare and instantiate a new 'BookServiceImpl' object called 'bkServiceImpl':
	//import it:
	private BookServiceImpl bkServiceImpl;
	
	//declare and instantiate a new 'BookDao' object called 'bkDao':
	//import it:
	private BookDao bkDao;
	
	//the first run in the sequence:
	@BeforeEach
	void setUp() throws Exception {
		//declare a new 'BookServiceImpl' object:
		bkServiceImpl = new BookServiceImpl();
		
		//declare a mock of the BookDao class:
		bkDao = Mockito.mock(BookDao.class);
		
		//set the BookDao mock into the 'BookServiceImpl' object:
		bkServiceImpl.setBookDao(bkDao);
	}
 
	//the last run in the sequence:
	@AfterEach
	void tearDown() throws Exception {
		//not needed because we are not destroying the set up environment
		//whenever you run it, the test class is creating a new instance of the object which automatically destroys/replaces the old instance. 
	}

	//The 'return true' outcome (from BookServiceImpl':
	//a test sequence:
	@DisplayName("Testing 'Add Book - return true'")
	@Test
	void testAddBookTrue() {
		//specify the behaviour of the mock:
		//use 'when-then()' method to execute a condition to mimic a behaviour when using 'Mockito':
		//import 'Book' entity:
		when(bkDao.insertBook(new Book(2001, "Private Peaceful", "Michael Morpurgo", 56))).thenReturn(1);
		
		//then use 'assertFalse' to check if the new Book object has been added:
		assertFalse(bkServiceImpl.addBook(new Book(2001, "Private Peaceful", "Michael Morpurgo", 56)));
	}
	
	//The 'return false' outcome (from BookServiceImpl':
	//a test sequence:
	@DisplayName("Testing 'Add Book - return false'")
	@Test
	void testAddBookFalse() {
		//specify the behaviour of the mock:
		//use 'when-then()' method to execute a condition to mimic a behaviour when using 'Mockito':
		//import 'Book' entity:
		when(bkDao.insertBook(new Book(2001, "Private Peaceful", "Michael Morpurgo", 56))).thenReturn(0);
		
		//then use 'assertTrue' to check if the new Book object has been added:
		assertTrue(bkServiceImpl.addBook(new Book(2001, "Private Peaceful", "Michael Morpurgo", 56)));
	}

	//The 'return true' outcome (from BookServiceImpl':
	//a test sequence:
	@DisplayName("Testing 'Delete Book - return true'")
	@Test
	void testDeleteBookTrue() {
		//specify the behaviour of the mock:
		//use 'when-then()' method to execute a condition to mimic a behaviour when using 'Mockito':
		when(bkDao.deleteBook(2001)).thenReturn(1);
		
		//then use 'assertTrue' to check if the new Book object has been added:
		assertTrue(bkServiceImpl.deleteBook(2001));
	}
	
	//The 'return false' outcome (from BookServiceImpl':
	//a test sequence:
	@DisplayName("Testing 'Delete Book - return false'")
	@Test
	void testDeleteBookFalse() {
		//specify the behaviour of the mock:
		//use 'when-then()' method to execute a condition to mimic a behaviour when using 'Mockito':
		when(bkDao.deleteBook(2001)).thenReturn(0);
		
		//then use 'assertTrue' to check if the new Book object has been added:
		assertFalse(bkServiceImpl.deleteBook(2001));
	}
}
