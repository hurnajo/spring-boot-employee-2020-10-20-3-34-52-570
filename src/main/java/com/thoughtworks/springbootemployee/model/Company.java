package com.thoughtworks.springbootemployee.model;

import java.util.List;

public class Company {
    String companyName;
    Integer employeesNumber;
    List<Employee> employees;

    public String getCompanyName() {
        return companyName;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
