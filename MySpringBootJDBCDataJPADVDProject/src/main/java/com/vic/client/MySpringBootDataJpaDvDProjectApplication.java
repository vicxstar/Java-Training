package com.vic.client;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vic.presentation.DvdLibraryPresentation;

/**
*
* @author vic
* date: 25/11/2022
* purpose: Step 9. The Main class
*
*/
//'@SpringBootApplication' is used to indicate that this class is a configuration class
@SpringBootApplication(scanBasePackages = "com.vic")
//'@EntityScan' configures the base packages used by the auto-config when scanning for entity classes:
@EntityScan(basePackages = "com.vic.entity")
//'@EnableJpaRepositories' enables JPA repositories. It will scan the package of the class for `Spring Data' repositories by default
@EnableJpaRepositories(basePackages = "com.vic.persistence")
public class MySpringBootDataJpaDvDProjectApplication {

	public static void main(String[] args) {
		
		//declare and initialise the scanner:
		//import the scanner:
		Scanner scanner = new Scanner(System.in);
				
		//instantiate a new 'springContainer' object:
		//import 'ApplicationContext':
		ApplicationContext springContainer = SpringApplication.run(MySpringBootDataJpaDvDProjectApplication.class, args);
		
		//instantiate a new 'DvdLibraryPresentation' object and use the spring container to get the associated @Beans:
		DvdLibraryPresentation dvdLibraryPres = (DvdLibraryPresentation)springContainer.getBean("dvdPresentation");
		
		//create a continuous loop to keep going until it a ‘break’ statement is reached:
		while(true) {
			//call the 'showMenu' method (from the presentation class):
			dvdLibraryPres.showMenu();
			
			//ask for user input:
			System.out.println("Enter Choice : ");
			int choice = scanner.nextInt();
			
			//call the 'performMenu' method (from the presentation class):
			dvdLibraryPres.performMenu(choice);
		}
	}
}
