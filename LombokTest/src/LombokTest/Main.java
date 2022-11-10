package LombokTest;

/**
 *
 * @author vic
 * date: 07/11/2022
 * purpose: Lombok Main Class
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//instantiate a new object of the 'Employee' class and fill it with the parameters stated in the class:
		Employee emp1 = new Employee(111, "Vic", "Manager", "Sales", 12342);
		
		//print the contents of the 'Employee' object, called 'emp1':
		System.out.println(emp1);
		

	}

}
