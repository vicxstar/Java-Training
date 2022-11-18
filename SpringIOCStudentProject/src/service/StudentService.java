package service;

import java.util.Collection;

import entity.Student;

/**
 *
 * @author vic
 * date: 11/11/2022
 * purpose: Step 4. The DTO INTERFACE (SERVICE LAYER)
 *
 */
public interface StudentService {

	//create the methods to make a call to the DAO to retrieve data from the database:
	//import 'Collection' and 'Student': 
	Collection<Student>getAllStudents();
	Student searchStudents(int rollNum);
	boolean addStudents(Student student);
}
