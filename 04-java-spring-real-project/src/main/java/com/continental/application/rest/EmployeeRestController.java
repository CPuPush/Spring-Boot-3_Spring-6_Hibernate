package com.continental.application.rest;

import com.continental.application.dao.EmployeeDAO;
import com.continental.application.entity.Employee;
import com.continental.application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;
    // quick and dirty: inject employee dao (use Constructor Injection)
    @Autowired
    private EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // expose "/employees/{employeeId}"
    @GetMapping("/employees/{employeeid}")
    public Employee getEmployee(@PathVariable int employeeid){
        Employee theEmployee = employeeService.findById(employeeid);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " +employeeid);
        }
        return theEmployee;
    }

    // expose "/employees" - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // also just in case they pass an id in JSON... set id to 0
        // this is to force a save of new idea .. instead of update
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // expose "/employees" -  update the existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    //expose "/employees/{id}" - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        // check theId
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted Employee id - " + employeeId;
    }
}
