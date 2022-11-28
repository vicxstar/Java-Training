package client;

import java.util.Scanner;
import presentation.BookPresentation;
import presentation.BookPresentationImpl;


/**
 *
 * @author vic
 * date: 10/11/2022
 * purpose: Step 9. The Main class
 *
 */
public class BookClient {

	public static void main(String[] args) {
		
		//declare and initialise the scanner:
		//import the scanner:
		Scanner scanner=new Scanner(System.in);
		
		//instantiate a new 'BookPresentation' object:
		BookPresentation bookPresentation = new BookPresentationImpl();
		
		//create a continuous loop to keep going until it a ‘break’ statement is reached:
		while(true) {
			//call the 'showMenu' method (from the presentation class):
			bookPresentation.showMenu();
			
			//ask for user input:
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			
			//call the 'performMenu' method (from the presentation class):
			bookPresentation.performMenu(choice);
		}
	}
}
