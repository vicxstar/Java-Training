package Student;

import java.util.Scanner;

/**
 *
 * @author vic
 * date: 04/11/2022
 * purpose: The Main Class
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//declare and initialise the scanner:
		Scanner inputScan = new Scanner(System.in);
		
		//try and catch statement:
		try {
			//ask for user input:
			System.out.println("Please input the total number of students you would like to register: ");
			int total = inputScan.nextInt();
			
			//instantiate a new 'RollList' object:
			RollList rollList = new RollList(total);
			
			//a 'for' loop to continue until the number inputed is completed:
			for (int index = 0; index < total; index++) {
				//instantiate a new Student object to input into each loop:
				Student stu = new Student();
				
				//ask for user input:
				System.out.println("Please enter the student's roll number: ");
				stu.setRollNo(inputScan.nextInt());
				
				System.out.println("Please input the student's age: ");
				stu.setAge(inputScan.nextInt());
				
				System.out.println("Please input the student's name: ");
				stu.setName(inputScan.next());
				
				System.out.println("Please input the student's marks: ");
				stu.setMarks(inputScan.nextDouble());
				
				//input into the 'RollNo' method to check for duplicated roll numbers:
				rollList.inputRollNo(stu, index);
				
			}
			//call the 'diaplayRollNo' method to display:
			rollList.displayRollNo();
		} 
		//the age exception (created):
		catch(AgeException exception) {
			System.out.println("Student must be aged between 4 and 18 to attend this school.");
		}
		//the marks exception (created):
		catch(MarksException e) {
			System.out.println("The marks be between 0 and 100.");
		} 
		//the multiple roll number exception (created):
		catch(RollNoException e) {
			System.out.println("This roll number has already been inputed.");
		}
		//the negative array exception (built-in):
		catch(NegativeArraySizeException e) {
			System.out.println("Your input cannot be a negative number.");
		}
		//the generic exception (built-in):
		catch(Exception e) {
			System.out.println("OOPS Something went wrong, please try after sometime!");
		}
	}

}
