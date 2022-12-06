package com.yusra.share.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.yusra")
@EntityScan(basePackages = "com.yusra.share.entity")
@EnableJpaRepositories(basePackages = "com.yusra.share.persistence")
public class MySpringBootWebMvcShareServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootWebMvcShareServiceProjectApplication.class, args);
	}

}
