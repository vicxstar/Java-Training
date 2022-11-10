/**
 * 
 */
package Employee;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/**
 *
 * @author vic
 * date: 08/11/2022
 * purpose: Tree Set Exercise - Main Class
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//instantiate a tree set with the 'Employee' object:
		//import the 'Set' and 'TreeSet' libraries:
		Set<Employee> empCollection=new TreeSet<Employee>();
		
		//declare and initialise the scanner:
		Scanner input = new Scanner(System.in);
		
		//declare and instantiate a new 'Employee' object:
//		Employee emp = new Employee();
		
		//declare a counter variable:
		int c = 0;
		
		//create a 'do-while' loop to ensure 3 inputs:
		do {
			//create a 'for' loop to get 3 inputs:
			for(int i = 0; i < 3; i++) {
				//ask for user input:
				System.out.println("Please input the employee's id: ");
				
				//store the id in 'ui':
				int uid = input.nextInt();
				
				//store the value into the 'Employee' object 'emp':
		//		emp.setId(uid);
				
				//ask for user input:
				System.out.println("Please input the employee's name: ");
				
				//store the name in 'ui':
				String uName = input.next();
				
				//store the value into the 'Employee' object 'emp':
		//		emp.setName(uName);
				
				//ask for user input:
				System.out.println("Please input the employee's department: ");
				
				//store the role in 'ui':
				String uDept = input.next();
				
				//store the value into the 'Employee' object 'emp':
		//		emp.setDepartment(uDept);
				
				//ask for user input:
				System.out.println("Please input the employee's role: ");
				
				//store the role in 'ui':
				String uRole = input.next();
				
				//store the value into the 'Employee' object 'emp':
		//		emp.setRole(uRole);
				
				//ask for user input:
				System.out.println("Please input the number of years the employee has worked in their role: ");
				
				//store the years in 'ui':
				int uYears = input.nextInt();
				
				//store the value into the 'Employee' object 'emp':
		//		emp.setExperienceYrs(uYears);
				
				//ask for user input:
				System.out.println("Please input the employee's salary: ");
				
				//store the department in 'ui':
				int uSalary = input.nextInt();
				
				//store the value into the 'Employee' object 'emp':
		//		emp.setSalary(uSalary);
				
				//add the input 'ui' into the collection by creating a new 'Employee' object:
				empCollection.add(new Employee(uid, uName, uDept, uRole, uYears, uSalary));
				//increase the value of 'c' by 1:
				c++;
				}
		//when 'c' (the loop counter) = 3, end the loop:
		} while(c < 3);
		
		//an enhanced 'for' loop to print the values in the collection:
		for(Employee emp : empCollection) {
			System.out.println(emp.getId() + emp.getName() + emp.getDepartment() + emp.getRole() + emp.getExperienceYrs() + emp.getSalary());
//			System.out.println("Employee's ID is: " + emp.getId() + ", Name is : " + emp.getName() + ", they work in the: " +emp.getDepartment() + " department, and they are a: " + emp.getRole() + ", they have: " + emp.getExperienceYrs() + " years of experience, and are earning: " + emp.getSalary() + " a month.");
			}
		
//		//using the 'iterator' method:
//		System.out.println("Traversal using Iterator");
//		//import the 'iterator' module:
//		Iterator<Employee> iterator=empCollection.iterator();
//		
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
	}
}
