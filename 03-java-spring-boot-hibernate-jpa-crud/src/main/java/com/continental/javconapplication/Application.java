package com.continental.javconapplication;

import com.continental.javconapplication.dao.StudentDAO;
import com.continental.javconapplication.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

//    create Command Line Runner
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner  -> {
                createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        // create  the student object
        System.out.println("Creating a new student object ...");
        Student student = new Student("fori", "okto", "test@gmail.com");

        // save the student object
        System.out.println("Save the Student to the database ...");
        studentDAO.save(student);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + student.getId());
    }
}
/*
* CommandLineRunner Executed after the Spring beans have been loaded
* CommandLineRunner from the Spring Boot Framework
* the code using Java Lambda Expression, it's simply like a shortcut notation
* For now i know why we use the CommandLineRunner. it is because we haven't create a rest api where we get an input from the body field. (then)
* We use CommandLineRunner to running the entity to database.
* with the CommandLineRunner, it's like we create our environment, and we can add input output manual from code and see the result in commandline, not from the IP ex http://localhost:8080/route
* */

/*
! DAO method
* save(...)
* findById(...)
* findAll(...)
* findByLastName(...)
* update(...)
* delete(...)
* deleteAll()
* */


/*
! Annotation
* @Entity => assign class to create a database
* @Repository => Specialized annotation for repository, support component scanning, Translates JDBC exception
* */


/*
! My note
* Student used to create the database characteristic
* but StudentDAO used to comunicate directly to the database
* */