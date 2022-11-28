package com.vic.client;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.vic.presentation.BookPresentation;



/**
*
* @author vic
* date: 24/11/2022
* purpose: Step 9. The Main class
*
*/
//
@SpringBootApplication(scanBasePackages = "com.vic")
public class MyFirstSpringBootProjectApplication {

	public static void main(String[] args) {
		//declare and initialise the scanner:
		//import the scanner:
		Scanner scanner=new Scanner(System.in);
		
		//instantiate a new 'springContainer' object:
		//import 'ApplicationContext'::
		ApplicationContext springContainer=SpringApplication.run(MyFirstSpringBootProjectApplication.class, args);
		
		//instantiate a new 'BookPresentation' object and use the spring container to get the associated @Beans:
		BookPresentation bookPresentation = (BookPresentation)springContainer.getBean("bkPresentation");
		
		//create a continuous loop to keep going until it a ‘break’ statement is reached:
		while(true) {
			//call the 'showMenu' method (from the presentation class):
			bookPresentation.showMenu();
			
			//ask for user input:
			System.out.println("Enter Choice : ");
			int choice = scanner.nextInt();
			
			//call the 'performMenu' method (from the presentation class):
			bookPresentation.performMenu(choice);
		}
	}

}
