package com.boot.employeeservice.model;

public record Employee(Long id, Long departmentId, String name, int age, String position) {

    //Record have constructor,toSting and Getters
    //not Setters
}
