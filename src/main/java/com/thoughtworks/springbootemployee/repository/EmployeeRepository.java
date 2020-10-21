package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> findAll() {
        return employees;
    }

    public Employee save(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee findById(Integer employeeId) {
        return employees.stream().filter(employee -> employee.getId() == employeeId).findFirst().orElse(null);
    }

    public Employee updateById(Integer employeeId, Employee updatedEmployee) {
        employees.stream().filter(employee -> employee.getId() == employeeId).findFirst().ifPresent(employee -> {
            employees.remove(employee);
            employees.add(updatedEmployee);
        });
        return updatedEmployee;
    }

    public void deleteById(Integer employeeId) {
        employees.stream().filter(employee -> employee.getId() == (employeeId)).findFirst().ifPresent(employees::remove);
    }
}
