package com.continental.application.dao;

import com.continental.application.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    // use list when return more than 1 output
    List<Employee> findAll();
    // when return only one output
    Employee findById(int theId);
    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
/*

* we define list because the return value will array(list of employee), that's mean more than one
* */