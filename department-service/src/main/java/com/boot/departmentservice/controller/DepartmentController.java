package com.boot.departmentservice.controller;

import com.boot.departmentservice.client.EmployeeClient;
import com.boot.departmentservice.model.Department;
import com.boot.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department){

        LOGGER.info("Department add : {} ",department);
        return repository.addDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){

        LOGGER.info("Department findById : id={} ",id);
        return repository.findById(id);
    }

    @GetMapping
    public List<Department> findAll(){

        LOGGER.info("DEpartment findAll ");
        return repository.findAll();
    }

    @GetMapping("/with-employee")
    public List<Department> findAllDeptWithEmp(){

        LOGGER.info("findAll Department with Employees");

        List<Department> departments =  repository.findAll();
        departments
                .forEach(department -> department.setEmployees
                        (employeeClient.findByDepartmentId(department.getId())));

        return departments;
    }

}
