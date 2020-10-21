package com.thoughtworks.springbootemployee.model;

import java.util.List;

public class Company {
    Integer companyId;
    String companyName;
    Integer employeesNumber;
    List<Employee> employees;

    public Company(Integer companyId, String companyName, Integer employeesNumber, List<Employee> employees) {
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
        this.employees = employees;
        this.companyId = companyId;
    }

    public Company() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Integer getCompanyId() {
        return companyId;
    }
}
