/**
 * 
 */
package com.vic.presentation;

import java.util.Collection;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vic.entity.Book;
import com.vic.service.BookService;


/**
 *
 * @author vic
 * date: 24/11/2022
 * purpose: Step 8. The PRESENTATION IMPLEMENTATION (PRESENTATION LAYER - implementation)
 *
 */
//specify the component name:
//this allows Spring to automatically detect our custom beans:
@Component("bkPresentation")
public class BookPresentationImpl implements BookPresentation{

	//instantiate a new object of the service implementation (SERVICE implementation) which implements the service interface:
	//import 'EmployeeService' and '@Autowired':
	//the '@Autowired' annotation is used to tell Spring which candidate it can use:
	@Autowired
	private BookService bookService;

	@Override
	public void showMenu() {
		System.out.println("===========================");
		System.out.println("Book Management System");
		System.out.println("1. List All Books");
		System.out.println("2. Search Books By ID");
		System.out.println("3. Add New Book");;
		System.out.println("4. Delete Book");
		System.out.println("5. Increment No. of Copies");
		System.out.println("6. Exit");
		System.out.println("============================");
	}

	@Override
	public void performMenu(int choice) {
		//declare and initialise a scanner for user input:
		Scanner scanner=new Scanner(System.in);
		
		//create the methods for the menu choices using ‘switch’ statements:
		//passing 'choice' from the 'client' Main class through the parameters:
		switch (choice) {
		case 1:
			//import 'Collections' and 'Book':
			Collection<Book> books = bookService.getAllBooks();
			
			for(Book bk : books) {
				System.out.println(bk);
			}
			break;
		
		case 2:
			//ask for user input:
			System.out.println("Enter Book ID : ");
			int id=scanner.nextInt();
			
			//instantiate a new 'Book' object and call the 'searchBook(id)' method (from serviceImpl):
			Book book = bookService.searchBooks(id);
			
			if(book != null)
				System.out.println(book);
			else 
				System.out.println("Book with ID '" + id + "' does not exist.");
			break;
		
		case 3:
			//instantiate a new 'Book' object:
			Book newBook = new Book();
			
			//ask for user input:
			System.out.println("Enter Book ID: ");
			String bid = scanner.nextLine();
			int iBid = Integer.parseInt(bid);
			newBook.setBookId(iBid);
			System.out.println("Enter Book Name: ");
			String bName = scanner.nextLine();
			newBook.setBookName(bName);
			System.out.println("Enter Author's Name: ");
			String aName = scanner.nextLine();
			newBook.setAuthorName(aName);
			System.out.println("Enter Number of Copies: ");
			String noC = scanner.nextLine();
			Integer iNoC = Integer.parseInt(noC);
			newBook.setNoOfCopies(iNoC);
			
			//check if the book has already been added:
			//if not, call the 'addBook()' method (from serviceImpl) and add the 'Book' object into the parameters:
			if(bookService.addBook(newBook))
				System.out.println("Book Record Added.");
			else 
				//if the book has already been added, tell the user:
				System.out.println("Book with ID '" + newBook.getBookId() + "' already exists, so cannot add it as a new book!");
			break;
		
		case 4:
			//ask for user input:
			System.out.println("Enter Book ID: ");
			int dbid = scanner.nextInt();
			
			//check if the book id exist by calling the 'deleteBook' method (from serviceImpl) :
			if(bookService.deleteBook(dbid))
				//if the id exists, delete the record:
				System.out.println("Book with ID '" + dbid + "' deleted");
			else
				//if the id does not exist, tell the user:
				System.out.println("Book with ID '" + dbid + "' does not exist");
			break;
			
		case 5:
			//ask for user input:
			System.out.println("Enter Book ID to be incremented : ");
			int nbid = scanner.nextInt();
			
			//ask for user input again:
			System.out.println("Enter amount of copies to increment by : ");
			int copies = scanner.nextInt();
			
			//check to see if the book copies have been updated:
			boolean hasBeenUpdated = bookService.incrementNoOfCopies(nbid, copies);
			
			if (hasBeenUpdated) 
				//if the id exists, delete the record:
				System.out.println("Number of copies successfully incremented.");
			else 
				//if the id does not exist, tell the user:
				System.out.println("No book exists with ID " + nbid);
			break;
			
		case 6:
			//the 'Exit' switch option:
			System.out.println("Thank you for using Book Management System!");
			//the exit function:
			System.exit(0);
			
		//if the user inputs an invalid option from the menu:	
		default:
			//tell the user:
			System.out.println("Invalid Choice! Please choose from the menu choices displayed above");
			break;
		}
	}
}

