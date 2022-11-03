package Reverse;

import java.util.Scanner;

/**
 * @author vic
 * date: 31/10/2022
 * purpose: Reverse a numbered input - The Main
 *
 */
public class Main {
	
	public static void main(String[] args) {
        //create an object (called 'rev') of the 'Reverse' class:
        Reverse rev = new Reverse();
        
        System.out.print("Please input a number you would like to reverse: ");
        
        Scanner input = new Scanner(System.in);
        int uInput = input.nextInt();
        
        //get the number using the setter:
        rev.setNumber(uInput);
         
        System.out.print("The reverse of '" + uInput + "' is : " + rev.getReverse());
        
        //close the 'input' scanner:
        input.close();
    }

}