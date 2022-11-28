package com.vic.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vic.entity.Book;
import com.vic.persistence.BookDaoImpl;



/**
 *
 * @author vic
 * date: 24/11/2022
 * purpose: The BookDaoImpl Testing Class
 *
 */
//can use '@DisplayName()' to name the test sequences:
@DisplayName("Testing BookDao")
@SpringBootTest
class BookDaoImplTest {

	//declare and instantiate a new 'BookDaoImpl' object called 'bkD':
	//the '@Autowired' annotation is used to tell Spring which candidate it can use:
	//import it:
	@Autowired
	BookDaoImpl bkD;
	
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
