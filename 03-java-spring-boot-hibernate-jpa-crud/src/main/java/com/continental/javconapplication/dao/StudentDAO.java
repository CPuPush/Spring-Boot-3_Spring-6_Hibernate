package com.continental.javconapplication.dao;

import com.continental.javconapplication.entity.Student;

import java.util.List;

public interface StudentDAO {
    //create a save method
    void save(Student theStudent);
    Student studentById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
}
/*
* create a interface DAO
* implement the DAO interface
* */

/*
! My Questions
* Why i have to create Student method inside the interface?
? the temp answer is the studentById instantiated to variabel Student class
* */