package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public Employee findById(Integer employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public Employee updateById(Integer employeeId, Employee employee) {
        return employeeRepository.updateById(employeeId, employee);
    }

    public void deleteById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> findByGender(String gender) {
        return employeeRepository.findByGender(gender);
    }

    public List<Employee> getByPage(int page, int pageSize) {
        return employeeRepository.getByPage(page,pageSize);
    }
}
