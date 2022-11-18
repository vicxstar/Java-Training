package client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import persistence.StudentDaoImpl;
import presentation.StudentPresentation;
import presentation.StudentPresentationImpl;
import service.StudentServiceImpl;

/**
 *
 * @author vic
 * date: 11/11/2022
 * purpose: Step 11a. The FIRST CONFIGURATION  (SERVICE LAYER - springContainer)
 *
 */

//annotate the file to indicate that this class has the '@Bean' definition method:
@Configuration
public class StudentConfiguration {

	//import the '@Bean' annotation method:
	@Bean(name = "dao")
	//import 'StudentDaoImpl':
	public StudentDaoImpl getPersistence() {
		return new StudentDaoImpl();
	}
	
	//THE CONSTRUCTOR INJECTION:
	@Bean(name = "service")
	//import 'StudentServiceImpl':
	public StudentServiceImpl getStudnetService() {
		return new StudentServiceImpl(getPersistence());
	}
	
	//THE SETTER INJECTION:
	@Bean(name = "stuPresentation")
	//import 'StudentPresentationImpl':
	public StudentPresentationImpl getStudentPresentation() {
		//instantiate a new 'StudentPresentationImpl' object:
		StudentPresentationImpl presentation = new StudentPresentationImpl();
		presentation.setStudentService(getStudnetService());
		return presentation;
	}
}
