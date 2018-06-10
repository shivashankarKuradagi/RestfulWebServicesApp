package com.shiv.restfill.app.RestFullWebServiceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.shiv.user.service.UserJPAService;

@SpringBootApplication(scanBasePackages= {"com.shiv.user.*"})
@EnableJpaRepositories(basePackages="com.shiv.user.service")
public class RestFullWebServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFullWebServiceAppApplication.class, args);
	}
}
