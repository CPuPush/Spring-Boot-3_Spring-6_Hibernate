package com.continental.application.dao;

import com.continental.application.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
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
3. Maven POM dependency for:  Spring-boot-starter-data-rest => see in application.properties

! we don't need Rest and service anymore, to see these folder, checkout the branch to 04-spring-boot-rest-crud-apis/03-crud-with-spring-data-jpa

* wow thats it, we don't need to code haha

! data rest
// not all the singular can handle by jpa
? so we have to configure it manually
@RepositoryRestResource(path="member")
ex mouse in plural is mice, not mouses

we can configure spring data rest in application.properties
* spring.data.rest.base-path
base path used to expose repository resources
* spring.data.rest.default-page-size
default size of pages for pagination
http://localhost:8080/magic-api/members?pages=2
ex we have 10 data, and, we assign default page size to 5, so the totalPages is 2

to query again
http://localhost:8080/magic-api/members?sort=id,desc
* spring.data.rest.max-page-size
maximum size of pages
* */
