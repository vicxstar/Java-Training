/**
 * 
 */
package Person;

import java.util.Scanner;

/**
 *
 * @author vic
 * date: 02/11/2022
 * purpose: Person Main Class
 *
 */
public class Main {

	public static void main(String args []) {
		
		//declare and initialise the scanner:
		Scanner input=new Scanner(System.in);
		
		//ask for user input:
		System.out.println("How many people would you like to record?: ");
		int total = input.nextInt();
		
		//instantiate a new 'PersonList' object:
		PersonList peopleList;
		
		//instantiate a new 'peopleList' object:
		peopleList = new PersonList(total); //has the 'total' in the parameters to get the total number of people
		
		//an enhanced 'for' loop to get user input for the amount of people they want to input:
		for(int index=0;index<total;index++) {
			Person person = new Person();
			System.out.println("Please enter no. " + (index+1) + "'s ID number : ");
			person.setId(input.nextInt());
			System.out.println("Please enter no. " + (index+1) + "'s name : ");
			person.setName(input.next());
			System.out.println("Please enter no. " + (index+1) + "'s age : ");
			person.setAge(input.nextInt());
			
			peopleList.inputPerson(person, index);
			
		}
		
		//call the 'displayPersonList' method from the 'PersonList' class:
		peopleList.displayPersonList();
		
		//close the scanner:
		input.close();
	}

}
