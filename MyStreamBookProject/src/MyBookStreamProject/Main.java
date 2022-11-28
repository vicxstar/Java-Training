package MyBookStreamProject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vic
 * date: 21/11/2022
 * purpose: Main
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//create a book list:
		//import 'List' and 'ArrayList':
		List<Book> bookList = new ArrayList<Book>();

		//add values to the list:
		bookList.add(new Book(1, "Book 1", "Author A", 1200, 5000));
		bookList.add(new Book(2, "Book 2", "Author M", 2100, 2000));
		bookList.add(new Book(3, "Book 3", "Author A", 3000, 6000));
		bookList.add(new Book(4, "Book 4", "Author D", 800, 2800));
		bookList.add(new Book(5, "Book 5", "Author M", 7200, 1100));
		bookList.add(new Book(6, "Book 6", "Author A", 8200, 4300));
		bookList.add(new Book(7, "Book 7", "Author A", 7900, 5600));
		
		//a stream to apply a 10% discount to all book prices:
//		bookList.stream()
//		.filter(book->book.getPrice()>5000)
//		.map(book->new BookDiscount(book, book.getPrice()*.10))
//		.forEach(bookWithDiscount->System.out.println(bookWithDiscount));
		
		//a stream to apply a 10% discount if price > 5000 and 5% discount if price <= 5000:
		
		//call '.stream() to the 'bookList' list to process the list:
		bookList.stream()
		//use the '.map()' function to manipulate the data to return specific results:
		.map(book -> {
			//declare 'BookDiscount' object called 'bD' and make it = 'null':
			BookDiscount bD = null;
			//an 'if' statement to check if the price  > 5000:
			if(book.getPrice() > 5000) {
				//apply a 10% discount if it is:
				bD = new BookDiscount(book, book.getPrice()*.10);
			}
			//'else if' statement to check if the price is <= 5000:
			else if(book.getPrice() <= 5000 ) {
				//apply a 5% discount if it is:
				bD = new BookDiscount(book, book.getPrice()*.05);
			}
			//return BookDiscount:
			return bD;
		} 
		//use '.forEach()' to apply the actions from '.map()' to (for) each element in the list:
		).forEach(bookWithDiscount->System.out.println(bookWithDiscount));
	}
}
