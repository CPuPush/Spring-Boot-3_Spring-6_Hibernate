package com.continental.javconapplication;

import com.continental.javconapplication.dao.StudentDAO;
import com.continental.javconapplication.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

//    create Command Line Runner
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner  -> {
//              createStudent(studentDAO);
//                readStudent(studentDAO);
//                readAllStudent(studentDAO);
            queryForStudentByLastName(studentDAO);

        };
    }

    private void queryForStudentByLastName(StudentDAO studentDAO) {
        // Get a list of student
        List<Student> theStudent = studentDAO.findByLastName("okto");
        for(Student student : theStudent){
            System.out.println(student);
        }
    }


    private void createStudent(StudentDAO studentDAO) {
        // create  the student object
        System.out.println("Creating a new student object ...");
        Student student = new Student("fori", "testt", "test@gmail.com");

        // save the student object
        System.out.println("Save the Student to the database ...");
        studentDAO.save(student);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + student.getId());
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating a new student object ...");
        Student student = new Student("nic", "testdic", "test@gmail.com");
        // save the save the student
        System.out.println("Save the Student to the database ...");
        studentDAO.save(student);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + student.getId());

        //display student
        Student myStudent = studentDAO.studentById(student.getId());
        System.out.println("Found the data: " + myStudent);
    }

    private void readAllStudent(StudentDAO studentDAO){

        // get a list of student
//        System.out.println(studentDAO.findAll()); => this is my way
        List<Student> listAllStudents = studentDAO.findAll();
//        System.out.println("Student List : \n" + listAllStudents);

        /*
        * [Student
        * {id=1, firstName='fori', lastName='okto', email='test@gmail.com'},
        * Student
        * {id=2, firstName='fori', lastName='okto', email='test@gmail.com'}
        * ]
        * the output is combining of array (Student mark), and key and value (ex id = 1)
        * */

        // display the list
//        for(Student listAllStudent : listAllStudents){
//            System.out.println(listAllStudent.getFirstName());
//            // so the list can call the all of method in the Student
//        }
        for(Student listAllStudent : listAllStudents){
            System.out.println(listAllStudent);
        }

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