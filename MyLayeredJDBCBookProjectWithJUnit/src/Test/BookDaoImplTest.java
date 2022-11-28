package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entity.Book;
import persistence.BookDaoImpl;

/**
*
* @author vic
* date: 21/11/2022
* purpose: The BookDaoImpl Testing Class
*
*/
//can use '@DisplayName()' to name the test sequences:
@DisplayName("Testing BookDao")
class BookDaoImplTest {

	//declare and instantiate a new 'BookDaoImpl' object called 'bkD':
	//import it:
	BookDaoImpl bkD;
	
	//the first run in the sequence:
	@BeforeEach
	void setUp() throws Exception {
		//declare a new 'BookDaoImpl' object:
		bkD = new BookDaoImpl();
	}

	//the last run in the sequence:
	@AfterEach
	void tearDown() throws Exception {
		bkD = null;
	}

	//a test sequence:
	//can use '@DisplayName()' to name the test sequences:
	@DisplayName("Testing 'Get All Books'")
	@Test
	void testGetAllBooks() {
		assertTrue(bkD.getAllBooks().size() > 0);
	}
	
	//a test sequence:
	@DisplayName("Testing 'Search Books'")
	@Test
	void testSearchBooks() {
		assertTrue(bkD.searchBooks(101) != null);
	}
	
	//a test sequence:
	@DisplayName("Testing 'Insert Book'")
	@Test
	void testInsertBook() {
		//needed to import 'Book'
		assertEquals(1, bkD.insertBook(new Book(2001, "Private Peaceful", "Michael Morpurgo", 56)));
	}
	
	//a test sequence:
	@DisplayName("Testing 'Delete Book'")
	@Test
	void testDeleteBook() {
		assertEquals(1, bkD.deleteBook(2001));
	}
}
