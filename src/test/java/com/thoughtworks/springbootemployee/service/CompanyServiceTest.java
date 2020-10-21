package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class CompanyServiceTest {
    CompanyRepository repository = Mockito.mock(CompanyRepository.class);

    @Test
    void should_get_all_when_get_company() {
        //given
        List<Company> expectedCompany = asList(new Company(), new Company());
        when(repository.findAll()).thenReturn(expectedCompany);
        CompanyService service = new CompanyService(repository);

        //when
        List<Company> actual = service.getAll();

        //given
        assertEquals(2, actual.size());
    }

    @Test
    void should_create_company_when_create_given_company() {
        //given
        List<Employee> employees = asList(new Employee(1, "Leo", 18, "male", 1000),
            new Employee(2, "Leo", 18, "male", 1000));
        Company company = new Company(1,"OOCL", 2, employees);
        CompanyService service = new CompanyService(repository);
        when(repository.save(company)).thenReturn(company);
        //when
        Company actual = service.create(company);
        //then
        assertEquals("OOCL", actual.getCompanyName());
    }

    @Test
    void should_get_company_when_get_by_name_given_company_id() {
        //given
        List<Employee> employees = asList(new Employee(1, "Leo", 18, "male", 1000),
                new Employee(2, "Leo", 18, "male", 1000));
        Company company = new Company(1,"OOCL", 2, employees);
        when(repository.findById(company.getId())).thenReturn(company);
        CompanyService service = new CompanyService(repository);
        //when
        Company actual = service.findById(company.getId());
        //then
        assertEquals(company.getId(),actual.getId());
    }

    @Test
    void should_get_list_of_employee_when_search_given_certain_company() {
        //given
        List<Employee> employees = asList(new Employee(1, "Leo", 18, "male", 1000),
                new Employee(2, "Leo", 18, "male", 1000));
        Company company = new Company(1,"OOCL", 2, employees);
        CompanyService service = new CompanyService(repository);
        //when
        List<Employee> actual = service.getEmployeeByCompanyId(company.getId());
        //then
        assertEquals(employees,actual);
    }

    @Test
    void should_update_company_when_update_by_company_id_given_company_id() {
        //given
        List<Employee> employees = asList(new Employee(1, "Leo", 18, "male", 1000),
                new Employee(2, "Leo", 18, "male", 1000));
        Company company = new Company(1,"OOCL", 2, employees);

        Company updateCompany = new Company(1,"COSCO",2, employees);
        when(repository.updateById(company.getId(),updateCompany)).thenReturn(updateCompany);
        CompanyService service = new CompanyService(repository);
        //when
        Company actual = service.updateById(company.getId(),updateCompany);
        //then
        assertEquals("COSCO",actual.getCompanyName());
    }

    @Test
    void should_delete_company_when_delete_by_company_id_given_company() {
        //given
        List<Employee> employees = asList(new Employee(1, "Leo", 18, "male", 1000),
                new Employee(2, "Leo", 18, "male", 1000));
        Company company = new Company(1,"OOCL", 2, employees);
        CompanyService service = new CompanyService(repository);
        //when
        service.deleteById(company.getId());
        //then
        verify(repository,times(1)).deleteById(company.getId());
    }
}
