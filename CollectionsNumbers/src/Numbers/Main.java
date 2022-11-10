/**
 * 
 */
package Numbers;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author vic
 * date: 07/11/2022
 * purpose: Collections Exercise - Main Class
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//declare and initialise a new Hash Set called 'numCollection':
		//import 'Set' and 'HashSet':
		//make sure the type being collected is the 'Numbers' class:
		Set <Numbers> numCollection = new HashSet <Numbers> ();
			
		//declare and initialise the scanner:
		Scanner input = new Scanner(System.in);
		
		//ask for user input:
		System.out.println("This system requires 10 number inputs");
		System.out.println();
		
		//declare a counter variable:
		int c = 0;
		
		//create a 'do-while' loop to ensure 10 numbers:
		do {
			//create a 'for' loop to get 10 inputs:
			for(int i = 0; i < 10; i++) {
				
				//ask for user input:
				System.out.println("Please input a number: ");
				
				//store the number in 'ui':
				int ui = input.nextInt();
				
				//to check for duplicate inputs:
				//declare a variable to count:
				int y = 0;
				
				//use a 'for' loop to check for duplicates:
				for(Numbers nu : numCollection) {
					if(nu.getNum() == ui) {
						System.out.println("This number has already been entered.");
						System.out.println();
						
						//increase 'y' by 1:
						y++;
					} 
				}
				if(y == 0) {
					//add the number 'ui' and it's index 'i' into the collection by creating a new 'Numbers' object:
					numCollection.add(new Numbers(ui, i));
					}
				
				//increase the value of 'c' by 1:
				c++;
				}
		//when 'c' (the loop counter) = 10, end the loop:
		} while(c < 10);
		
		//print the collection:
		System.out.println("These are the numbers inputted: ");
		System.out.println();
		
		//an enhanced 'for' loop to print the values in the collection:
		for(Numbers nu : numCollection) {
			System.out.println("In this collection the number: " + nu.getNum() + " is placed at index: " +nu.getIndex());
			}
	}
}
