package com.shiv.restfill.app.RestFullWebServiceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.shiv.*")
public class RestFullWebServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFullWebServiceAppApplication.class, args);
	}
}
