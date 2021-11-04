package com.bridgelabz.EmployeePayRollApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeePayRollAppApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(EmployeePayRollAppApplication.class,args);
	log.info("Employee payroll app started in {} Environment",
			 context.getEnvironment().getProperty("environment"));
	}

}
