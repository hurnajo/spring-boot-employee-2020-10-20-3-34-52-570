package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
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

    public List<Employee> findByGender(String gender) {
        return null;
    }

    public List<Employee> getByPage(Integer page, Integer pageSize) {
        return employees.stream()
                .skip((pageSize -1) * page)
                .limit(pageSize)
                .collect(Collectors.toList());
    }
}
