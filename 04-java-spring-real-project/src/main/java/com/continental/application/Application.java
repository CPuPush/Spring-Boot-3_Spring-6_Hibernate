package com.continental.application;

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
* @Entity =>
* @Table => create table or mapping to database that created before
* @Id => create field to primary key
* @GeneratedValue => used to specify how the primary key value of the entity generated
* strategy = GenerationType.IDENTITY => indicated the database will automatically generate the primary key values for the newly inserted rows
* @Column(name = "id") => mapping in to the database field name
* @RestController => assign a class to be a controller to handle the Business Process
* @RequestMapping("/api") => create like container to wrapping the route of the API
* @Service => sit between RestController and EmployeeDao. to have a single view from a advance business logic
* @Repository => build on the top of the classes that manage the code related to the database
* @Autowired => allows spring to resolve and inject collaborating beans into our bean
* @Transaction => used when we have transaction (add, update, delete) to database, but when we implement transaction in service layer, we don't use it because it will be handled at Service Layer

* */