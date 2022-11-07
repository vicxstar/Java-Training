package Employee;

/**
*
* @author vic
* date: 04/11/2022
* purpose: Employee List Class
*
*/
public class EmployeeList {

	//declare the variables:
	private Employee[] empList;
	private int totalEmp;
	
	//the parameters constructor
	public EmployeeList(int totalEmp) {
		super();
		this.totalEmp = totalEmp;
		empList = new Employee[totalEmp];
	}
	
	//method to check the names inputed:
	public void inputEmployee(Employee employee, int index) throws NameException {
		//an enhanced 'for' loop:
		for (int i = 0; i < index; i++) {
			if (empList[i].getName().equals(employee.getName()))
				//the exception method for name:
				throw new NameException("This employee's name has already been inputed");
			}
		empList[index] = employee;
	}
	
	//the display method:
	public void displayEmployees() {
		for(Employee emp : empList)
			emp.display();
	}
}
