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
import static org.mockito.Mockito.when;

public class CompanyServiceTest {

    @Test
    void should_get_all_when_get_company() {
        //given
        List<Company> expectedCompany = asList(new Company(), new Company());
        CompanyRepository repository = Mockito.mock(CompanyRepository.class);
        when(repository.findAll()).thenReturn(expectedCompany);
        CompanyService service = new CompanyService(repository);

        //when
        List<Company> actual = service.getAll();

        //given
        assertEquals(2, actual.size());
    }
}
