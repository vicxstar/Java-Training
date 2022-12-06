package com.vic.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
*
* @author vic
* date: 29/11/2022
* purpose: The Main/Client Class
*
*/
@SpringBootApplication(scanBasePackages = "com.vic")
public class MySpringBootMvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootMvcProjectApplication.class, args);
	}

}
