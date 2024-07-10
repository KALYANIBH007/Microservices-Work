package com.boot.employeeservice.repository;

import com.boot.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    public List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee){

        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id){

        return employees.stream()
                .filter(employee -> employee.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAll(){

        return employees;
    }

    public List<Employee> findByDepartmentId(Long departmentId){

        return employees.stream()
                .filter(employee -> employee.departmentId().equals(departmentId))
                .findFirst()
                .stream().toList();
    }
}