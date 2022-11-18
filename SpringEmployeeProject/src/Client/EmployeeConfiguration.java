package Client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Persistence.EmployeeDaoImpl;
import Presentation.EmployeePresentationImpl;
import Service.EmployeeServiceImpl;

/**
 *
 * @author vic
 * date: 10/11/2022
 * purpose: Step 11. The CONFIGURATION  (SERVICE LAYER - springContainer)
 *
 */

//annotate the file to indicate that this class has the '@Bean' definition method:
@Configuration
public class EmployeeConfiguration {
	
	//import the '@Bean' annotation method:
	@Bean(name="dao")
	//import 'EmployeeDaoImpl':
	public EmployeeDaoImpl getPersistence() {
		return new EmployeeDaoImpl();
	}
	
	@Bean(name="service")
	//import 'EmployeeServiceImpl':
	public EmployeeServiceImpl getEmployeeService() {
		//the Constructor Injection:
		return new EmployeeServiceImpl(getPersistence());
	}
	
	@Bean(name="empPresentation")
	//import 'EmployeePresentationImpl':
	public EmployeePresentationImpl getEmployeePresentation() {
		//the Setter Injection:
		EmployeePresentationImpl presentation=new EmployeePresentationImpl();
		presentation.setEmployeeService(getEmployeeService());
		return presentation;
	}
}
