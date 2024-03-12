package com.continental.javconapplication.dao;

import com.continental.javconapplication.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    //inject the entity manager using constructor
    @Autowired // this is optional
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //implement the save method
    @Transactional //saving or storing an object in the database, we are using from the spring framework.. performing updates to database
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student studentById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);
        // return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName){
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student  where lastName=:theData", Student.class);
        //set the parameter
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }


    @Override
    @Transactional
    public void update(Student theStudent){
        //update the student
        entityManager.merge(theStudent);

    }

}
/*
* don't forget to annotate the class
* entityManager responsible for CRUD operation on entities, as well as query database
! persist
* is to save to the database

! find
* find(<the real entity class>, <the id>)

! TypedQuery
* we can customize the query
* from Student => for all data
* from Student where lastName='okto' => retrieve only okto data names
* from Student order by id asc/desc
* */