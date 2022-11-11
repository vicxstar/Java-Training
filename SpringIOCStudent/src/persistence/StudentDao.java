package persistence;

import java.util.Collection;

import entity.Student;

/**
 *
 * @author vic
 * date: 11/11/2022
 * purpose: Step 3. The DAO INTERFACE (PERSISTENCE LAYER)
 *
 */
public interface StudentDao {

	//create the methods for the menu:
	//import 'collection' and 'Student':
	Collection<Student>getAllStudents();
	Student searchStudents(int rollNum);
	Student insertStudent(Student student);
}
