package com.luv2code.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

}
/*
! 1. Add Security in pom.xml
by add starter security, spring boot will automagically secure all endpoints for application by default
but we can login to the application by using "user" username and password in console by default spring generator.
we can modify user and password in properties
* */