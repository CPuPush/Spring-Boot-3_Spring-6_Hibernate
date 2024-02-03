package com.continental.javcon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// example
// component scanning solver => explicitly list base packages to scan
//@SpringBootApplication(
//		scanBasePackages = {
//				"com.continental.javcon",
//				"com.love.util"
//		}
//)
@SpringBootApplication
public class JavconApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavconApplication.class, args);
	}

}

/*
! Component Scanning note
* this is like register the package to the SpringBootApplication so that the other package can scan the bean annotation for adding to spring container
* */