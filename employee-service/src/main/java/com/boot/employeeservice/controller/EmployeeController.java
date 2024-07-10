package com.boot.employeeservice.controller;

import com.boot.employeeservice.model.Employee;
import com.boot.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;

    @PostMapping
    public Employee add(@RequestBody Employee employee){

        return repository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> findAll(){

        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id){

        return repository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartmentId(@PathVariable("departmentId") Long departmentId){

        return  repository.findByDepartmentId(departmentId);
    }

}
