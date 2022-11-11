package persistence;

import java.util.Collection;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import database.StudentDataBase;
import entity.Student;

/**
 *
 * @author vic
 * date: 11/11/2022
 * purpose: Step 6. DAO implementation (PERSISTENCE LAYER - implementation)
 *
 */

//FOR STUDENT CONFIGURATION JAVA 2:
//specify the component name:
//this allows Spring to automatically detect our custom beans:
@Component("dao")

//FOR STUDENT CONFIGURATION XML 2:
//import '@Repository':
@Repository("dao")
public class StudentDaoImpl implements StudentDao{

	//Override the methods from the DAO interface (menu system):
	@Override
	public Collection<Student> getAllStudents() {
		//import 'StudentDataBase':
		return StudentDataBase.getStudentList().values();
	}

	@Override
	public Student searchStudents(int rollNum) {
		return StudentDataBase.getStudentList().get(rollNum);
	}
	
	@Override
	public Student insertStudent(Student student) {
		return StudentDataBase.getStudentList().put(student.getRollNum(), student);
	}
}
