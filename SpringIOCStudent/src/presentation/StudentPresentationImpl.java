package presentation;

import java.util.Collection;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import entity.Student;
import service.StudentService;
import service.StudentServiceImpl;

/**
 *
 * @author vic
 * date: 11/11/2022
 * purpose: Step 8. The PRESENTATION IMPLEMENTATION (PRESENTATION LAYER - implementation)
 *
 */

//FOR STUDENT CONFIGURATION JAVA 2 and XML 2:
//specify the component name:
//this allows Spring to automatically detect our custom beans:
@Component("stuPresentation")
public class StudentPresentationImpl implements StudentPresentation{

	//instantiate a new object of the service implementation (SERVICE implementation) which implements the service interface:
	//import 'StudentService' and 'StudentServiceImpl':
//	private StudentService studentService = new StudentServiceImpl();
	
	//declare an 'StudentService' object:
	private StudentService studentService;
	
	//the '@Autowired' annotation is used to tell Spring which candidate it can use:
	@Autowired
	//the '@Qualifier' is used in all implementations of an interface (when there is more than 1 implementation of an interface):
	@Qualifier("service")
	//generate setter:
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@Override
	public void showMenu() {
		System.out.println("===========================");
		System.out.println("Student Management System");
		System.out.println("1. List All Students");
		System.out.println("2. Search Students By Roll Number");
		System.out.println("3. Add New Student");;
		System.out.println("4. Exit");
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
			//import 'Collections' and 'Student':
			Collection<Student> students = studentService.getAllStudents();
			
			for(Student stu : students) {
				System.out.println(stu);
			}
			break;
		
		case 2:
			//ask for user input:
			System.out.println("Enter Student ID : ");
			int id=scanner.nextInt();
			
			//instantiate a new 'Student' object and call the 'searchStudent(id)' method (from serviceImpl):
			Student student = studentService.searchStudents(id);
			
			if(student != null) {
				System.out.println(student);
			}
			else
				System.out.println("Student with ID '" + id + "' does not exist");
			break;
			
		case 3:
			//instantiate a new 'Student' object:
			Student newStudent = new Student();
			
			//ask user for input:
			System.out.println("Enter Student Roll Number: ");
			String sid = scanner.nextLine();
			int isid = Integer.parseInt(sid);
			
			//add the input into the 'newStudent' object:
			newStudent.setRollNum(isid);
			
			//ask user for input:
			System.out.println("Enter Student's Name: ");
			String sName = scanner.nextLine();
			
			//add the input into the 'newStudent' object:
			newStudent.setName(sName);
			
			//ask user for input:
			System.out.println("Enter Student Grades: ");
			String sGrade = scanner.nextLine();
			int iSgrade = Integer.parseInt(sGrade);
			
			//add the input into the 'newStudent' object:
			newStudent.setGrade(iSgrade);
			
			//check if the student has already been added:
			//if not, call the 'addStudent()' method (from serviceImpl) and add the 'Student' object into the parameters:
			if(studentService.addStudents(newStudent))
				System.out.println("Student Record Added");
			else 
				//if
				System.out.println("Student with Roll Number '" + newStudent.getRollNum() + "' already exist, so cannot add it as a new student!");
			break;
			
		case 4:
			//the 'Exit' switch option:
			System.out.println("Thank you for using the Student Management System!");
			//the exit function:
			System.exit(0);
			
		//if the user inputs an invalid option from the menu:	
		default:
			//tell the user:
			System.out.println("Invalid Choice! Please choose from the menu choices displayed above");
			break;
		}	
	}
}
