package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CompanyServiceTest {
    private CompanyRepository repository = Mockito.mock(CompanyRepository.class);

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

        Company company = new Company(1, "OOCL");
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
        Company company = new Company(1, "OOCL");
        when(repository.findCompanyById(company.getCompanyId())).thenReturn(company);
        CompanyService service = new CompanyService(repository);
        //when
        Company actual = service.findById(company.getCompanyId());
        //then
        assertEquals(company.getCompanyId(), actual.getCompanyId());
    }

    @Test
    void should_get_list_of_employee_when_search_given_certain_company() {
        //given
        Company company = new Company(1, "Telus");
        Employee employee = new Employee(1, "Tom", 18, "Male", 1000, 1);

        when(repository.getEmployeesByCompanyId(company.getCompanyId())).thenReturn(Collections.singletonList(employee));
        CompanyService companyService = new CompanyService(repository);
        //when
        List<Employee> actual = companyService.getEmployeesByCompanyId(company.getCompanyId());
        //then
        assertTrue(actual.contains(employee));
    }

    @Test
    void should_update_company_when_update_by_company_id_given_company_id() {
        //given
        Company company = new Company(1, "OOCL");
        Company updateCompany = new Company(1, "COSCO");

        when(repository.updateCompanyById(company.getCompanyId(), updateCompany)).thenReturn(updateCompany);
        CompanyService service = new CompanyService(repository);
        //when
        Company actual = service.updateById(company.getCompanyId(), updateCompany);
        //then
        assertEquals("COSCO", actual.getCompanyName());
    }

    @Test
    void should_delete_company_when_delete_by_company_id_given_company() {
        //given
        Company company = new Company(1, "OOCL");
        CompanyService service = new CompanyService(repository);
        //when
        service.deleteById(company.getCompanyId());
        //then
        verify(repository, times(1)).deleteById(company.getCompanyId());
    }
}
