package com.continental.javconapplication.dao;

import com.continental.javconapplication.entity.Student;

public interface StudentDAO {
    //create a save method
    void save(Student theStudent);
    Student studentById(Integer id);
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