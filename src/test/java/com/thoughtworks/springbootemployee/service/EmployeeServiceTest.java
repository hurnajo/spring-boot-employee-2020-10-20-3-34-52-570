package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {
    EmployeeRepository repository = Mockito.mock(EmployeeRepository.class);

    @Test
    void should_get_all_when_get_employees() {
        //given

        List<Employee> expectedEmployees = asList(new Employee(), new Employee());
        when(repository.findAll()).thenReturn(expectedEmployees);
        EmployeeService service = new EmployeeService(repository);

        //when
        List<Employee> actual = service.getAll();

        //given
        assertEquals(2, actual.size());
    }

    @Test
    void should_create_employee_when_create_given_employee() {
        //given
        Employee employee = new Employee(1, "Leo", 18, "male", 1000);
        EmployeeService service = new EmployeeService(repository);
        when(repository.save(employee)).thenReturn(employee);
        //when
        Employee actual = service.create(employee);
        //then
        assertEquals(1, actual.getId());
    }

    @Test
    void should_get_employee_when_get_by_id_given_employee_id() {
        //given
        Employee employee = new Employee(1, "Leo", 18, "male", 1000);
        when(repository.findById(employee.getId())).thenReturn(employee);
        EmployeeService service = new EmployeeService(repository);
        //when
        Employee actual = service.findById(employee.getId());
        //then
        assertEquals(employee.getId(), actual.getId());
    }

    @Test
    void shoud_return_all_male_gender_when_filter_given_male_gender() {
        //given
        String gender = "Male";
        Employee firstemployee = new Employee(1, "Leo", 18, "male", 1000);
        Employee secondemployee = new Employee(1, "Leo", 18, "male", 1000);
        when(repository.findByGender(gender)).thenReturn(asList(firstemployee, secondemployee));
        EmployeeService service = new EmployeeService(repository);
        //when
        List<Employee> actual = service.findByGender(gender);
        //then
        assertEquals(asList(firstemployee, secondemployee), actual);
    }

    @Test
    void should_update_employee_when_update_by_employee_id_given_employee_id() {
        //given
        Employee employee = new Employee(1, "Leo", 18, "male", 1000);
        Employee updateEmployee = new Employee(1, "Leo", 18, "male", 2000);
        when(repository.updateById(employee.getId(), employee)).thenReturn(updateEmployee);
        EmployeeService service = new EmployeeService(repository);
        //when
        Employee actual = service.updateById(employee.getId(), employee);
        //then
        assertNotEquals(employee.getSalary(), actual.getSalary());
    }

    @Test
    void should_delete_employee_when_delete_by_employee_id_given_employee() {
        //given
        Employee employee = new Employee(1, "Leo", 18, "male", 1000);
        EmployeeService service = new EmployeeService(repository);
        //when
        service.deleteById(employee.getId());
        //then
        verify(repository, times(1)).deleteById(employee.getId());
    }

    @Test
    void should_return_2_company_when_getByPage_given_employee_request() {
        //given
        List<Employee> employeeList = asList(new Employee(),
                new Employee(), new Employee(), new Employee(), new Employee());
        when(repository.getByPage(1, 5)).thenReturn(employeeList);
        EmployeeService employeeService = new EmployeeService(repository);
        //when
        List<Employee> employeeActual = employeeService.getByPage(1, 5);
        //then
        assertEquals(5, employeeActual.size());
    }
}
