package com.continental.application.dao;

import com.continental.application.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
    // no need to write any code.. wow
    // and we can use EmployeeRepository with
}
