package database;

import java.util.LinkedHashMap;
import java.util.Map;

import entity.Student;

/**
 *
 * @author vic
 * date: 11/11/2022
 * purpose: Step 2. The DATABASE
 *
 */
public class StudentDataBase {

	//Initialise a linked has map:
	//import 'map', 'hashmap' and the entity 'Student':
	static private Map<Integer, Student> studentList = new LinkedHashMap<Integer, Student>();
	
	//put values into 'studentList':
	static {
		studentList.put(100, new Student(100, "Jennifer", 80));
		studentList.put(101, new Student(101, "Victoria", 90));
		studentList.put(102, new Student(102, "Dorcas", 85));
		studentList.put(103, new Student(103, "Lewis", 70));
		studentList.put(104, new Student(104, "Stanny", 82));
		studentList.put(105, new Student(105, "Richard", 99));
	}
	
	//create another map to get the list:
	public static Map<Integer, Student> getStudentList() {
		return studentList;
	}
}
