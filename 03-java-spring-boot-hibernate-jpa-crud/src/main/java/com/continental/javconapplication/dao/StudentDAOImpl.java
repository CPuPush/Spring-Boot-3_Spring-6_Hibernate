package com.continental.javconapplication.dao;

import com.continental.javconapplication.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
/*
* don't forget to annotate the class
* entityManager responsible for CRUD operation on entities, as well as query database
! persist
* is to save to the database
* */