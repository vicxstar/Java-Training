package com.vic.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
*
* @author vic
* date: 30/11/2022
* purpose: The Main/Client Class
*
*/
@SpringBootApplication(scanBasePackages = "com.vic")
//'@EntityScan' configures the base packages used by the auto-config when scanning for entity classes:
@EntityScan(basePackages = "com.vic.entity")
//'@EnableJpaRepositories' enables JPA repositories. It will scan the package of the class for `Spring Data' repositories by default:
@EnableJpaRepositories(basePackages = "com.vic.persistence")
public class MySpringBootMvcEmployeeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootMvcEmployeeProjectApplication.class, args);
	}

}
