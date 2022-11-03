package Eggs;

import java.util.Scanner;

/**
*
* @author vic
* date: 31/10/2022
* purpose: Eggs Exercise - main
* 
*/
public class Main {
   
   public static void main(String[] args) {
		
		//instantiate an object of the 'Eggs' class:
       Eggs myEgg = new Eggs();
       
       System.out.print("How many eggs do you have?: ");
       
       //ask from user input:
       Scanner input = new Scanner(System.in);
       int uInput = input.nextInt();
       
       //add the input into the instantiated object's parameter:
       myEgg.setEggs(uInput);
       
       System.out.print("There are " + myEgg.getGross() + " gross of eggs, " + myEgg.getDozen() + " dozen eggs, and " + myEgg.getRemain() + " eggs remaining");

       //close the 'input' scanner:
       input.close();
	}
   
}
