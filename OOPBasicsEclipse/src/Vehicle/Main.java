package Vehicle;

import java.util.Scanner;

/**
 * @author vic
 * date: 01/11/2022
 * purpose: Main Class
 *
 */
public class Main {

	public static void main(String[] args) {
		
		Vehicle vechicle = new Vehicle();
		
		//ask from user input:
		System.out.println("What type of vehicle do you have?: ");
		Scanner input = new Scanner(System.in);
		String vType = input.nextLine();

		//set the input into the 'Vehicle' class's private variable 'type' using its setter:
		vechicle.setType(vType);
		
		//ask from user input:
		System.out.println("What make is your " + vType + "?: ");
		String vMake = input.nextLine();
		
		//set the input into the 'Vehicle' class's private variable 'make' using its setter:
		vechicle.setMake(vMake);
		
		//ask from user input:
		System.out.println("And what is your " + vMake + "'s model number?: ");
		int vModNum = input.nextInt();
		
		//set the input into the 'Vehicle' class's private variable 'modelNum' using its setter:
		vechicle.setModelNum(vModNum);
		
		System.out.println("=================");
		
		Car car = new Car();
		
		//ask from user input:
		System.out.println("What colour is your " + vType + "?: ");
		String cColour = input.next();
		
		//set the input into the 'Car' class's private variable 'colour' using its setter:
		car.setColour(cColour);
		
		//ask from user input:
		System.out.println("How many doors does your " + vType + " have?: ");
		int cDoors = input.nextInt();
				
		//set the input into the 'Car' class's private variable 'noOfDoors' using its setter:
		car.setNoOfDoors(cDoors);
		
		//ask from user input:
		System.out.println("How many wheels does your " + vType + " have?: ");
		int cWheels = input.nextInt();
						
		//set the input into the 'Car' class's private variable 'noOfWheels' using its setter:
		car.setNoOfWheels(cWheels);
		
		//call the 'displayInfo' method from the 'Vehicle' class:
		vechicle.displayInfo();
		//call the 'displayCarDetails' method from the 'Car' class:
		car.displayCarDetails();
		
		//close the 'input' scanner:
        input.close();
	}

}
