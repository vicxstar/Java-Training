package client;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import presentation.StudentPresentation;
import presentation.StudentPresentationImpl;

/**
 *
 * @author vic
 * date: 11/11/2022
 * purpose: Step 9. The Main class
 *
 */
public class StudentClient {

	public static void main(String[] args) {
		
		//declare and initialise the scanner:
		//import the scanner:
		Scanner scanner=new Scanner(System.in);
		
		//instantiate a new object of the presentation implementation class (which implements the presentation interface):
		//import 'StudentPresentation' and 'StudentPresentationImpl':
//		StudentPresentation studentPresentation=new StudentPresentationImpl();
		
		//FOR STUDENT CONFIGURATION JAVA 1:
		//instantiate a new 'springContainer' object:
		//import 'AnnotationConfigApplicationContext':
//		AnnotationConfigApplicationContext springContainer=new AnnotationConfigApplicationContext(StudentConfiguration.class);
		//instantiate a new 'BookPresentation' object and use the spring container to get the associated @Beans:
//		StudentPresentation studentPresentation = (StudentPresentation) springContainer.getBean("stuPresentation");
		
		//FOR STUDENT CONFIGURATION JAVA 2:
		//instantiate a new 'springContainer' object:
		//import 'AnnotationConfigApplicationContext':
		AnnotationConfigApplicationContext springContainer=new AnnotationConfigApplicationContext(StudentConfiguration2.class);
		//instantiate a new 'BookPresentation' object and use the spring container to get the associated @Beans:
		StudentPresentation studentPresentation2 = (StudentPresentation) springContainer.getBean("stuPresentation");
		
		//FOR STUDENT CONFIGURATION XML 1:
		//Create an 'ApplicationContext' object called 'springContainer':
		//import 'ApplicationContext' and 'ClassPathXmlApplicationContext':	
//		ApplicationContext springContainer = new ClassPathXmlApplicationContext("studentconfiguration.xml");
		//instantiate a new 'BookPresentation' object and use the spring container to get the associated @Beans:
//		StudentPresentation studentPresentation3 = (StudentPresentation) springContainer.getBean("stuPresentation");
		
		//FOR STUDENT CONFIGURATION XML 2:
		//Create an 'ApplicationContext' object called 'springContainer':
		//import 'ApplicationContext' and 'ClassPathXmlApplicationContext':	
//		ApplicationContext springContainer = new ClassPathXmlApplicationContext("studentconfiguration2.xml");
		//instantiate a new 'BookPresentation' object and use the spring container to get the associated @Beans:
//		StudentPresentation studentPresentation4 = (StudentPresentation) springContainer.getBean("stuPresentation");
		
		
		//create a continuous loop to keep going until it a ‘break’ statement is reached:
		while(true) {
			//call the 'showMenu' method (from the presentation class):
			
			//FOR STUDENT CONFIGURATION JAVA 1:
//			studentPresentation.showMenu();
			
			//FOR STUDENT CONFIGURATION JAVA 2:
			studentPresentation2.showMenu();
			
			//FOR STUDENT CONFIGURATION XML 1:
//			studentPresentation3.showMenu();
			
			//FOR STUDENT CONFIGURATION XML 2:
//			studentPresentation4.showMenu();
			
			//ask for user input:
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			
			
			//call the 'performMenu' method (from the presentation class):
			
			//FOR STUDENT CONFIGURATION JAVA 1:
//			studentPresentation.performMenu(choice);
			
			//FOR STUDENT CONFIGURATION JAVA 2:
			studentPresentation2.performMenu(choice);
			
			//FOR STUDENT CONFIGURATION XML 1:
//			studentPresentation3.performMenu(choice);
			
			//FOR STUDENT CONFIGURATION XML 2:
//			studentPresentation4.performMenu(choice);
		}
	}
}
