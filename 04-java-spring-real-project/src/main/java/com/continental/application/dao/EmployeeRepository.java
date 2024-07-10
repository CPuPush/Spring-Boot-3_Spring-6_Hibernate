package com.continental.application.dao;

import com.continental.application.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
    // no need to write any code.. wow
    // and we can use EmployeeRepository with


}
/*
? create DAO, plug  in my entity type and primary key, and give me all the DAO CRUD Basic
! Spring Data JPA Solution
* Spring Data JPA gives you a CRUD Implementation for free
* just by plug in entity and primary key like above

get these method for free:
* findAll
* findById
* save
* deleteById
* others
https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html


? Create REST API , use my existing JpaRepository(entity and primaryKey), amd give me all the REST API CRUD Features for free
! Spring Data Rest Solution
only need 3 items
1. Entity
2. JpaRepository: ex EmployeeRepository extends JpaRepository
3. Maven POM dependency for:  Spring-boot-starter-data-rest
* */
