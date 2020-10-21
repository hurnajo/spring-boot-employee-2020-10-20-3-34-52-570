package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    private final List<Employee> employees = new ArrayList<>();
    private EmployeeService employeeService =
            new EmployeeService(new EmployeeRepository());


    @GetMapping
    public List<Employee> getAll() {
        return employees;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }

    @GetMapping("/{employeeId}")
    public Employee get(@PathVariable Integer employeeId) {
        return employees.stream().filter(employee -> employee.getId().equals(employeeId)).findFirst().orElse(null);
    }

    @PutMapping("/{employeeId}")
    public Employee update(@PathVariable Integer employeeId, @RequestBody Employee employeeUpdate) {
        employees.stream()
                .filter(employee -> employee.getId().equals(employeeId))
                .findFirst()
                .ifPresent(employee -> {
                    employees.remove(employee);
                    employees.add(employeeUpdate);
                });
        return employeeUpdate;
    }

    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable Integer employeeId) {
        employees.stream()
                .filter(employee -> employee.getId().equals(employeeId))
                .findFirst()
                .ifPresent(employees::remove);
    }

    @GetMapping(params = "gender")
    public List<Employee> getByGender(@RequestParam("gender") String gender) {
        return employees.stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }

    @GetMapping(params = {"page", "pageSize"})
    public List<Employee> getByPage(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) {
        return employeeService.getByPage(page,pageSize);
    }
}
