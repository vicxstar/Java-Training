package database;

import java.util.LinkedHashMap;
import java.util.Map;
import entity.Book;

/**
 *
 * @author vic
 * date: 10/11/2022
 * purpose: Step 2. The DATABASE
 *
 */
public class BookDataBase {

	//Initialise a linked has map:
	//import 'map', 'hashmap' and the entity 'Book':
	static private Map<Integer, Book> bookList = new LinkedHashMap<Integer, Book>();
	
	//put values into 'bookList':
	static {
		bookList.put(100, new Book(100, "To Kill A Mockingbird", "Harper Lee", 15));
		bookList.put(101, new Book(101, "North Child", "Edith Pattou", 10));
		bookList.put(102, new Book(102, "The Seven Husbands Of Evelyn Hugo", "Taylor Jenkins Reid", 5));
		bookList.put(103, new Book(103, "The Sisters Grimm", "Michael Buckley", 4));
		bookList.put(104, new Book(104, "Skin Of The Sea", "Natasha Bowen", 7));
		bookList.put(105, new Book(105, "The Midnight Library", "Matt Haig", 9));
	}
	
	//create another map to get the list:
	public static Map<Integer, Book> getBookList() {
		return bookList;
	}
}
