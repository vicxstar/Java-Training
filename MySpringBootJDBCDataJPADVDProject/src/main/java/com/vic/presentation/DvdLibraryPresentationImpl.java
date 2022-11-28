/**
 * 
 */
package com.vic.presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Collection;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vic.entity.DvdLibrary;
import com.vic.service.DvdLibraryService;


/**
 *
 * @author vic
 * date: 25/11/2022
 * purpose: Step 8. The PRESENTATION IMPLEMENTATION (PRESENTATION LAYER - implementation)
 *
 */
//specify the component name:
//this allows Spring to automatically detect our custom beans:
@Component("dvdPresentation")
public class DvdLibraryPresentationImpl implements DvdLibraryPresentation {

	//instantiate a new object of the service implementation (SERVICE implementation) which implements the service interface:
	//import 'DvdLibraryService' and '@Autowired':
	//the '@Autowired' annotation is used to tell Spring which candidate it can use:
	@Autowired
	private DvdLibraryService dvdLibraryService;
	
	@Override
	public void showMenu() {
		System.out.println("===========================");
		System.out.println("DVD Management System");
		System.out.println("1. List All DVDs");
		System.out.println("2. Search DVD By ID");
		System.out.println("3. Add New DVD");
		System.out.println("4. Delete DVD");
		System.out.println("5. Edit DVD");
		System.out.println("6. Exit");
		System.out.println("============================");
		
	}

	@Override
	public void performMenu(int choice) {
		//declare and initialise a scanner for user input:
		Scanner scanner = new Scanner(System.in);
		
		//create the methods for the menu choices using ‘switch’ statements:
		//passing 'choice' from the 'client' Main class through the parameters:
		switch (choice) {
		//List All Dvds:
		case 1:
			//import 'Collections' and 'DvdLibrary':
			Collection<DvdLibrary> dvdLibraries = dvdLibraryService.getAllDvds();
			
			for(DvdLibrary dvd : dvdLibraries) {
				System.out.println(dvd);
			}
			break;
			
		//Search DVD by ID:	
		case 2:
			//ask for user input:
			System.out.println("Enter DVD ID: ");
			int id = scanner.nextInt();
			
			//instantiate a new 'Book' object and call the 'searchBook(id)' method (from serviceImpl):
			DvdLibrary dvd = dvdLibraryService.searchDvds(id);
			
			//check if the dvd ID exist:
			if(dvd != null)
				//if it does, display it:
				System.out.println(dvd);
			else 
				//if it deosn't, tell the user:
				System.out.println("Dvd with ID '" + id + "' does not exist");
			break;
		
		//Add New DVD:	
		case 3:
			//instantiate a new 'DvdLibrary' object:
			DvdLibrary newDvd = new DvdLibrary();
			
			//ask for user input:
			System.out.println("Please enter the Dvd ID: ");
			String dvdid = scanner.nextLine();
			int idvdid = Integer.parseInt(dvdid);
			newDvd.setDvdId(idvdid);
			
			System.out.println("Please enter the Dvd Title: ");
			newDvd.setTitle(scanner.nextLine());
			
			System.out.println("Please enter the Dvd Release Date (dd-Mon-yyyy): ");
			//import 'DateTimeFormatter' and 'DateTimeFormatterBuilder'
			DateTimeFormatter df = new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ofPattern("d-MMM-yyyy")).toFormatter();
			newDvd.setReleaseDate(LocalDate.parse(scanner.nextLine(), df));
			
			
			System.out.println("Please enter the MPAA Rating (ie: PG): ");
			String dvdM = scanner.nextLine();
			newDvd.setMpaaRating(dvdM);
			
			
			System.out.println("Please enter the Director's Name: ");
			newDvd.setDirectorsName(scanner.nextLine());
			
			
			System.out.println("Please enter the Production the Dvd Movie Was Made By: ");
			newDvd.setStudio(scanner.nextLine());
			
			
			System.out.println("Please enter the User's Review: ");
			newDvd.setUserReview(scanner.nextLine());
			
			
			//check if a dvd has already been added:
			//if not: call the 'addDvd()' method (from serviceImpl) and add the 'DvdLibrary' object into the parameters:
			if(dvdLibraryService.addDvd(newDvd))
				System.out.println("Dvd Record Successfully Added");
			else 
				//if that dvd has already been added, tell the user:
				System.out.println("Dvd with ID '" + newDvd.getDvdId() + "' already exists, so the system cannot add it as a new Dvd");
			break;
			
		//Delete DVD:
		case 4:
			//ask for user input:
			System.out.println("Enter DVD ID: ");
			int did = scanner.nextInt();
			
			//check if the dvd id exist by calling the 'deleteDvd' method (from serviceImpl) :
			if(dvdLibraryService.deleteDvd(did))
				//if the id exists, delete:
				System.out.println("Dvd With ID '" + did + "' deleted");
			else 
				//if the id does not exist, tell the user:
				System.out.println("Dvd with ID '" + did + "' does not exist");
			break;
			
		//Edit DVD:
		case 5:
			//ask for user input:
			System.out.println("Enter DVD ID: ");
			String edid = scanner.nextLine();
			int iedid = Integer.parseInt(edid);
			//instantiate a new 'DvdLibrary' object:
			DvdLibrary newdvd = dvdLibraryService.searchDvds(iedid);
			
			//an 'if' statement to check if the id exists:
			if(dvdLibraryService.editDvd(iedid)) {
				//ask for user input:
				System.out.println("Which DVD field would you like to edit?: ");
				System.out.println("Dvd ID, Title, Release Date, MPAA Rating, Director's Name, Production Studio, or User Review");
				String uinput = scanner.nextLine(); 
				
				
				//check which option the user picked:
				if(uinput.equals("id")) {
					//ask for user input to update:
					System.out.println("Please Update the Dvd's ID: ");
					String idd = scanner.nextLine();
					int iidd = Integer.parseInt(idd);
					//set the update into the 'DvdLibrary' object:
					newdvd.setDvdId(iidd);
				} 
				//else, check which option the user picked:
				else if(uinput.equals("title")) {
					//ask for user input to update:
					System.out.println("Please Update the Dvd's Title: ");
					//set the update into the 'DvdLibrary' object:
					newdvd.setTitle(scanner.nextLine());
				} 
				//else, check which option the user picked:
				else if(uinput.equals("date")) {
					//ask for user input to update:
					System.out.println("Please Update the Dvd's Release Date: ");
					//set the update into the 'DvdLibrary' object:
					//import 'DateTimeFormatter' and 'DateTimeFormatterBuilder'
					DateTimeFormatter ndf = new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ofPattern("d-MMM-yyyy")).toFormatter();
					newdvd.setReleaseDate(LocalDate.parse(scanner.nextLine(), ndf));
				} 
				//else, check which option the user picked:
				else if(uinput.equals("director")) {
					//ask for user input to update:
					System.out.println("Please Update the Dvd's Director's Name: ");
					//set the update into the 'DvdLibrary' object:
					newdvd.setDirectorsName(scanner.nextLine());
				} 
				//else, check which option the user picked:
				else if(uinput.equals("rating")) {
					//ask for user input to update:
					System.out.println("Please Update the Dvd's MPAA Rating: ");
					//set the update into the 'DvdLibrary' object:
					newdvd.setMpaaRating(scanner.nextLine());
				}
				//else, check which option the user picked:
				else if(uinput.equals("studio")) {
					//ask for user input to update:
					System.out.println("Please Update the Dvd's Production Studio: ");
					//set the update into the 'DvdLibrary' object:
					newdvd.setStudio(scanner.nextLine());
				}
				//else, check which option the user picked:
				else if(uinput.equals("review")) {
					//ask for user input to update:
					System.out.println("Please Update the User's Review: ");
					//set the update into the 'DvdLibrary' object:
					newdvd.setUserReview(scanner.nextLine());
				}
				dvdLibraryService.updateDvd(newdvd);
			}
			//if the id does not exist:
			else {
				//tell the user:
				System.out.println("Dvd with id '" + edid + "' does not exist");
			}
			break;
			
		case 6:
			//'Exit' option switch:
			System.out.println("Thanks for using Employee Management System");
			//exit function:
			System.exit(0);
		//if the user inputs an invalid option from the menu:	
		default:
			//tell the user:
			System.out.println("Invalid Choice! Please choose from the menu choices displayed above");
			break;
		}
	}
}