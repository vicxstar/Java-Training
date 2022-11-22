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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import entity.Book;
import persistence.BookDao;
import service.BookServiceImpl;

/**
 *
 * @author vic
 * date: 21/11/2022
 * purpose: The BookService Mockito AnnotaionsTesting Class
 *
 */
//can use '@DisplayName()' to name the test sequences:
@DisplayName("Testing BookService with Mockito and Annotations")

//use '@RunWith' to initialise and allow the explicit usage of MockitoAnnotations.:
//import '@RunWith'
@RunWith(MockitoJUnitRunner.class)
class BookServiceMockitoAnnotationTest {

	//declare and instantiate a new 'BookServiceImpl' object called 'bkServiceImpl':
	//import it:
	//use '@InjectMocks' to allow Mockito to try to inject mocks:
	@InjectMocks
	private BookServiceImpl bkServiceImpl;
	
	//declare and instantiate a new 'BookDao' object called 'bkDao':
	//import it:
	//use '@Mock' to minimise repetitive mock creation:
	@Mock
	private BookDao bkDao;
	
	//declare and initalise a new 'AutoCloseable' object called 'autoC':
	//import it:
	//'AutoCloseable' is used to hold resources until they are closed
	private AutoCloseable autoC;
	
	//the first run in the sequence:
	@BeforeEach
	void setUp() throws Exception {
		//use 'MockitoAnnotations.openMocks(this)' to initialise fields annotated with mockito annotations
		//it tells Mockito to scan the test class instance for all the fields annotated with @Mock
		//and initialise those fields as mocks:
		autoC = MockitoAnnotations.openMocks(this);
	}
 
	//the last run in the sequence:
	@AfterEach
	void tearDown() throws Exception {
		//use 'autoC.close()' to close the resources:
		autoC.close();
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
	
	//THIS RUN SHOULD FAIL IF THE BOOKSERVICEIMPL SYNTAX IS CORRECT//
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
	
	//THIS RUN SHOULD FAIL IF THE BOOKSERVICEIMPL SYNTAX IS CORRECT//
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
