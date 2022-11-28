package Presentation;

import java.time.LocalDate; //better than using 'sql.date' or 'util.date'
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Entity.Employee;
import Entity.EmployeePaySlip;
import Service.EmployeeService;
import Service.EmployeeServiceImpl;

/**
 *
 * @author vic
 * date: 09/11/2022
 * purpose: Step 8. The PRESENTATION IMPLEMENTATION (PRESENTATION LAYER - implementation)
 *
 */
//FOR STUDENT CONFIGURATION JAVA 2 and XML 2:
//specify the component name:
//this allows Spring to automatically detect our custom beans:
@Component("empPresentation")
public class EmployeePresentationImpl implements EmployeePresentation{
	
	//instantiate a new object of the service implementation (SERVICE implementation) which implements the service interface:
	//import 'EmployeeService' and '@Autowired':
	@Autowired
	private EmployeeService employeeService;

	
	//override the methods from the PRESENTATION interface:
	@Override
	public void showMenu() {
		System.out.println("===========================");
		System.out.println("Employee Management System");
		System.out.println("1. List All Employees");
		System.out.println("2. Search Employee By ID");
		System.out.println("3. Add New Employee");
		System.out.println("4. Delete Employee");
		System.out.println("5. Increment Salary");
		System.out.println("6. Generate PaySlip");
		System.out.println("7. Search Employee by Department");
		System.out.println("8. Exit");
		System.out.println("============================");
	}

	@Override
	public void performMenu(int choice) {
		
		//declare and initialise a scanner for user input:
		Scanner scanner=new Scanner(System.in);
		
		//create the methods for the menu choices using ‘switch’ statements:
		//passing 'choice' from the 'client' Main class through the parameters:
		switch (choice) {
		case 1:
			//import 'Collections' and 'Employee':
			Collection<Employee> employees=employeeService.getAllEmployees();
			
			for(Employee emp:employees) {
				System.out.println(emp);
			}
			break;
			
		case 2:
			//ask for user input:
			System.out.println("Enter Employee ID : ");
			int id=scanner.nextInt();
			
			//instantiate a new 'Employee' object and call the 'searchEmployee(id)' method (from serviceImpl):
			Employee employee=employeeService.searchEmployeeById(id);
			
			if(employee!=null)
				System.out.println(employee);
			else
				System.out.println("Employee with id "+id+" doesnot exist");
			break;
			
		case 3:
			//instantiate a new 'Employee' object:
			Employee newEmployee=new Employee();
			
			//ask for user input:
			System.out.println("Enter Employee ID: ");
			newEmployee.setEmpId(scanner.nextInt());
			System.out.println("Enter Employee First Name: ");
			newEmployee.setEmpFirstName(scanner.next());
			System.out.println("Enter Employee Last Name: ");
			newEmployee.setEmpLastName(scanner.next());
			System.out.println("Enter Employee Email: ");
			newEmployee.setEmpEmail(scanner.next());
			System.out.println("Enter Employee Phone Number: ");
			newEmployee.setEmpPhoneNum(scanner.next());
//			System.out.println("Enter Employee Hire Date (YYYY-MM-DD): ");
//			LocalDate date = LocalDate(scanner.next());
//			newEmployee.setHireDate(date);
			
			System.out.println("Enter Employee Hire Date (dd-Mon-yyyy): ");
			//import 'DateTimeFormatter' and 'DateTimeFormatterBuilder'
			DateTimeFormatter df = new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ofPattern("d-MMM-yyyy")).toFormatter();
			
			newEmployee.setHireDate(LocalDate.parse(scanner.next(),df));
			
			System.out.println("Enter Employee Job ID: ");
			newEmployee.setJobId(scanner.next());
			System.out.println("Enter Employee Salary : ");
			newEmployee.setEmpSalary(scanner.nextDouble());
			System.out.println("Enter Employee Commission : ");
			newEmployee.setEmpCommission(scanner.nextDouble());
			System.out.println("Enter Manager ID: ");
			newEmployee.setManagerId(scanner.nextInt());
			System.out.println("Enter Department ID: ");
			newEmployee.setDepartmentId(scanner.nextInt());
			System.out.println("Enter Department Name: ");
			newEmployee.setDepartmentName(scanner.next());
			
			//check if an employee has already been added:
			//if not: call the 'addEmployee()' method (from serviceImpl) and add the 'Employee' object into the parameters:
			if(employeeService.addEmployee(newEmployee))
				System.out.println("Employee Record Added");
			else
				//if that employee has already been added, tell the user:
				System.out.println("Employee with id "+newEmployee.getEmpId()+" already exist, so cannot add it as a new employee!");
			break;
			
		case 4:
			//ask for user input:
			System.out.println("Enter Employee ID : ");
			int eId=scanner.nextInt();
			
			//check if the employee id exist by calling the 'deleteEmployee' method (from serviceImpl) :
			if(employeeService.deleteEmployee(eId))
				//if the id exists, delete:
				System.out.println("Employee with id "+eId+" deleted");
			else
				//if the id does not exist, tell the user:
				System.out.println("Employee with id "+eId+" does not exist");
			break;
			
		case 5:
			//ask from user input:
			System.out.println("Enter Employee ID : ");
			int empId=scanner.nextInt();
			
			//ask for user input:
			System.out.println("Enter Increment Amount : ");
			
			//declare and initialise a scanner to except doubles
			double increment=scanner.nextDouble();
			
			//check to see if the employee id exists:
			// if it does, call the 'incrementSalary' method (from serviceImpl):
			if(employeeService.incrementSalary(empId, increment))
				System.out.println("Employee with Id "+empId+" salary incremented with amount "+increment);
			else
				//if employee does not exist, tell the user:
				System.out.println("Employee with ID "+empId+" does not exist");
			break;
			
		case 6:
			//ask for user input:
			System.out.println("Enter Employee ID : ");
			int employeeId=scanner.nextInt();
			
			//instantiate a new 'EmployeePaySlip' object and call the ''generatePaySlip) method (from serviceImpl):
			//import the 'EmployeePaySlip' class:
			EmployeePaySlip payslip=employeeService.generatePaySlip(employeeId);
			
			//check if the employee exists:
			//if they do, then print the payslip:
			if(payslip!=null)
				System.out.println(payslip);
			else
				//if the employee does not exist, tell the user:
				System.out.println("Employee with id "+employeeId+" does not exist!");
			break;
			
		case 7:
			//ask for user input:
			System.out.println("Enter Employee Department : ");
			String employeeDept = scanner.next();
			
			//instantiate a new 'Employee' list and call the 'employeeByDepartment' method (from serviceImpl):
			//import the 'List' function
//			Collection<Employee> emp = employeeService.employeeByDepartment(employeeDept);
			Collection<Employee> emp = employeeService.searchEmployeeByDepartment(employeeDept);
			
			//create an 'if' statement to check if the department inputed exists:
			//if the department does exist print all the information:
			if(emp != null) {
				System.out.println(emp);
			}
			//if the department does not exist, tell the user:
			else {
				System.out.println("Department '" + employeeDept + "' does not exist!");
			}
			break;
			
		case 8:
			//'Exit' option switch:
			System.out.println("Thanks for using Employee Management System");
			//exit function:
			System.exit(0);
		default:
			//if the user inputs an invalid option from the menu:
			System.out.println("Invalid Choice!");
			break;
		}
	}
}
