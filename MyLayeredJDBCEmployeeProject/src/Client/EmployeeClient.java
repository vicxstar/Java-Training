package Client;

import java.util.Scanner;

import Presentation.EmployeePresentation;
import Presentation.EmployeePresentationImpl;

/**
 *
 * @author vic
 * date: 09/11/2022
 * purpose: Step 9. The Main class
 *
 */
public class EmployeeClient {

	public static void main(String[] args) {
		
		//declare and initialise the scanner:
		//import the scanner:
		Scanner scanner=new Scanner(System.in);
		
		//instantiate a new object of the presentation implementation class (which implements the presentation interface):
		//import 'EmployeePresentation' and 'EmployeePresentationImpl':
		EmployeePresentation employeePresentation=new EmployeePresentationImpl();
		
		//create a continuous loop to keep going until it a ‘break’ statement is reached:
		while(true) {
			//call the 'showMenu' method (from the presentation class):
			employeePresentation.showMenu();
			
			//ask for user input:
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			
			//call the 'performMenu' method (from the presentation class):
			employeePresentation.performMenu(choice);
		}
	}

}
