package service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import entity.Student;
import persistence.StudentDao;
import persistence.StudentDaoImpl;

/**
 *
 * @author vic
 * date: 11/11/2022
 * purpose: Step 7. The SERVICE IMPLEMENTAION  (SERVICE LAYER - implementation)
 *
 */
//FOR STUDENT CONFIGURATION JAVA 2:
//specify the component name:
//this allows Spring to automatically detect our custom beans:
@Component("service")

//FOR STUDENT CONFIGURATION XML 2:
//import '@Service':
@Service("service")
public class StudentServiceImpl implements StudentService{

	//Instantiate a new object of the 'persistence implementation' class - StudentDaoImpl (which implements the persistence interface):
	//import 'StudentDao' and 'StudentDaoImpl':
//	private StudentDao studentDao = new StudentDaoImpl();
	
	//declare an 'StudentDao' object:
	private StudentDao studentDao;
	
	//generate a parameters constructor:
	//the '@Autowired' annotation is used to tell Spring which candidate it can use:
	//generate a parameters constructor:
	public StudentServiceImpl(@Autowired StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}
	
	//override the methods from the DTO (service layer) INTERFACE:
	@Override
	public Collection<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public Student searchStudents(int rollNum) {
		return studentDao.searchStudents(rollNum);
	}
	
	@Override
	public boolean addStudents(Student student) {
		Student stu = studentDao.searchStudents(student.getRollNum());
		if(stu != null) {
			return false;
		}
		studentDao.insertStudent(student);
		return true;
	}
}
