package continental.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

/*
! Annotation
* @ExceptionHandler => for handle exception, this annotation run when something wrong with our code
* @PostConstruct => run the block code when application running
* @ControllerAdvice => global exception
* */