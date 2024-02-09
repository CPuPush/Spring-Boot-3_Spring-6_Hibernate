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

/*
! Annotation
? @Component => allow Spring to detect our custom beans (commonly are the method that we develop from interface)
? @RestController => to simplify the creation of RESTful web service (Combine @Controller and @ResponseBody)
? @@GetMapping("/blablabla") => create endpoint for our api
? @Primary => resolving @Component multiple implementation. and set one component to be specific.
? @Qualifier => same with @Primary but higher priority than @Primary
? @Lazy => instantiate the class when needed. if it's not needed, they won't create
? @Scope => until this project, scope use to create another instantiate from the same class because the bean have singleton approach
? @PostConstruct => starting first, usefull for DB configuration example
? @PreConstruct => run after application want to shut down
* */