package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Employee oldEmployee, Employee newEmployee) {
        if(oldEmployee.getId().equals(newEmployee.getId())){
            employeeRepository.delete(oldEmployee);
            employeeRepository.save(newEmployee);
        }
        return newEmployee;
    }
}
