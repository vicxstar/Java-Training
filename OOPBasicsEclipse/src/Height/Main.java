package Height;

import java.util.Scanner;

/**
 * @author vic
 * date: 01/11/2022
 * purpose: Height Exercise - Main
 *
 */
public class Main {

	public static void main(String[] args) {

		//instantiate an object from the 'Height' class to collect the first height measurements:
		Height h1 = new Height();
		
		//instantiate an object from the 'Height' class to collect the second height measurements:
		Height h2 = new Height();
		
		//ask from user input:
		System.out.print("Please input the first feet measurement: ");
		Scanner input = new Scanner(System.in);
        int uiF1 = input.nextInt();
        
        //set the input into the 'Height' class's private variable 'feet' using its setter:
        h1.setFeet(uiF1);
		
		System.out.print("Please input the first inches measurement: ");
		int uiI1 = input.nextInt();
        
        //set the input into the 'Height' class's private variable 'inches' using its setter:
        h1.setInches(uiI1);
        
        //print the inputs:
        System.out.println("The first Height measurement is '" + h1.getFeet() + " feet' " + h1.getInches() + " inches'.");
		
	    //ask from user input:
	    System.out.print("Please input the second feet measurement: ");
        int uiF2 = input.nextInt();
              
        //set the input into the 'Height' class's private variable 'feet' using its setter:
        h2.setFeet(uiF2);
        
        //ask from user input:
      	System.out.print("Please input the second inches measurement: ");
      	int uiI2 = input.nextInt();
              
      	//set the input into the 'Height' class's private variable 'inches' using its setter:
        h2.setInches(uiI2);
       
        //print the inputs:
        System.out.println("The second Height measurement is '" + h2.getFeet()+ " feet' " + h2.getInches() + " inches'.");
        
        //declare a new instance of the 'Height' class called 'height' to collect the calculation method:
        Height height = new Height();
        
        //run the 'sum' method from the 'height' class in the new 'height' instance using the 'getFeet' and 'getInches' objects:
        height.sum(h1, h2);
        
        //close the 'input' scanner:
        input.close();
	}
}
