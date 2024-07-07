package com.continental.application.dao;

import com.continental.application.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entity manager (bridge between application and the database)
    private EntityManager entityManager;

    //setup constructor injection
    // entity manager automatically created by SpringBoot and we can simply inject it into our application
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the result
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee employee = entityManager.find(Employee.class, theId);

        //return the employee
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save employee
        Employee dbEmployee = entityManager.merge(theEmployee);
        /*
        * merge mean:
        * if id == 0 then insert/save
        *           else update
        * */
        //return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // find employee
        Employee employee = entityManager.find(Employee.class, theId);

        //remove employee
        entityManager.remove(employee);
    }
}

/*
* @Repository =>
* @Autowired =>
* public EmployeeDAOJpaImpl(EntityManager entityManager){
? automatically created by Spring Boot and we can simplify inject in constructor into our application (constructor injection    )
* */