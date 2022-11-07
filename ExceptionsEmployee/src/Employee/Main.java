package Employee;

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
	
		Scanner inputScan = new Scanner(System.in);
		try {
			System.out.println("Enter total number of employees : ");
			int total = inputScan.nextInt();

			EmployeeList employeeList = new EmployeeList(total);

			for (int index = 0; index < total; index++) {
				Employee emp = new Employee();

				System.out.println("Enter Employee Name : ");
				emp.setName(inputScan.next());
				System.out.println("Enter Employee Age : ");
				emp.setAge(inputScan.nextInt());

				employeeList.inputEmployee(emp, index);
			}
			employeeList.displayEmployees();
		} catch (AgeException exception) {
			System.out.println(exception.getMessage());
		} 
		catch (NameException e) {
			System.out.println(e.getMessage());
		}
		catch(NegativeArraySizeException e) {
			System.out.println("Total No of employee cannot be negative");
		}
		catch(Exception e) {
			System.out.println("OOPS Something went wrong, please try after sometime!");
		}
		
		//close the scanner:
		inputScan.close();
	}
}
