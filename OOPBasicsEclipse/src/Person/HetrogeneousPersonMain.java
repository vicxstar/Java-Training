/**
 * 
 */
package Person;

import java.util.Scanner;

/**
 *
 * @author vic
 * date: 03/11/2022
 * purpose: Main Class
 *
 */
public class HetrogeneousPersonMain {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
				
		System.out.println("Enter total No of Persons ");
		int total=input.nextInt();
				
		PersonList personList;
		personList=new PersonList(total);
				
		for(int index=0;index<total;index++) {
			Person p;
			System.out.println("Please enter emp for employee and ent for enterpreneur: ");
			String choice=input.next();
			if(choice.equals("emp")) {
				
				System.out.println("Enter the Employee's ID: ");
				int eId = input.nextInt();
				
				System.out.println("Enter the Employee's Name: ");
				String eNa = input.next();
				
				System.out.println("Enter the Employee's Age: ");
				int eAge = input.nextInt();
				
				System.out.println("Enter the Employee's Designation: ");
				String des = input.next();
				
				System.out.println("Enter the Employee's Department: ");
				String deptt = input.next();
				
				System.out.println("Enter the Employee's Salary: ");
				double sal = input.nextDouble();
				
				p = new Employee(eId, eNa, eAge, des, deptt, sal);
			}
			else {
				System.out.println("Enter the Enterpreneur's ID: ");
				int id = input.nextInt();
				
				System.out.println("Enter the Enterpreneur's Name: ");
				String na = input.next();
				
				System.out.println("Enter the Enterpreneur's Age ");
				int age = input.nextInt();
				
				System.out.println("Enter the Nature Of Bussiness: ");
				String bs = input.next();
				
				System.out.println("Enter the TurnOver: ");
				double to = input.nextDouble();
				
				p=new Entrepreneur(id, na, age, bs, to);
			}
				
			personList.inputPerson(p, index);
			
		}

		personList.displayPersonList();
		
		//close the scanner:
		input.close();
	}
}
