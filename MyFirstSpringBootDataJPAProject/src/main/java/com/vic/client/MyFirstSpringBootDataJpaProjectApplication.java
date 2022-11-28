package com.vic.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vic.entity.Student;
import com.vic.persistence.StudentDao;

/**
*
* @author vic
* date: 25/11/2022
* purpose: Step 9. The Main class
*
*/
//'@SpringBootApplication' is used to indicate that this class is a configuration class
@SpringBootApplication
//'@EntityScan' configures the base packages used by the auto-config when scanning for entity classes:
@EntityScan(basePackages = "com.vic.entity")
//'@EnableJpaRepositories' enables JPA repositories. It will scan the package of the class for `Spring Data' repositories by default
@EnableJpaRepositories(basePackages = "com.vic.persistence")
public class MyFirstSpringBootDataJpaProjectApplication {

	public static void main(String[] args) {
		//instantiate a new 'springContainer' object:
		//import 'ApplicationContext':
		ApplicationContext springContainer = SpringApplication.run(MyFirstSpringBootDataJpaProjectApplication.class, args);
		
		//instantiate a new 'StudentDao' object and use the spring container to get the associated @Beans:
		StudentDao dao = (StudentDao)springContainer.getBean("studentDao");
		
		//use '.save()' method to add and save some data into the database table called 'Student':
		//if it doesn't exist, it will create it and name the columns with the names of the variables declared in the 'Student' entity class
		dao.save(new Student(1, "Vic", "Address A", "vic@email.com", 15));
		dao.save(new Student(2, "Jen", "Address B", "jen@email.com", 10));
		dao.save(new Student(3, "Dan", "Address C", "dan@email.com", 20));
		dao.save(new Student(4, "Tia", "Address D", "tia@email.com", 25));
	}

}
