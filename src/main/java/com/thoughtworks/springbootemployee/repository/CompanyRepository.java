package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CompanyRepository {
    private List<Company> companies = new ArrayList<>();

    public List<Company> findAll() {
        return companies;
    }

    public Company save(Company company) {
        companies.add(company);
        return company;
    }

    public Company findCompanyById(Integer companyId) {
        return companies.stream().filter(company -> company.getCompanyId() == companyId).findFirst().orElse(null);
    }

    public Company updateCompanyById(Integer id, Company updatedCompany) {
        companies.stream().filter(company -> company.getCompanyId() == id).findFirst().ifPresent(employee -> {
            companies.remove(employee);
            companies.add(updatedCompany);
        });
        return updatedCompany;
    }

    public void deleteById(Integer id) {
        companies.stream().filter(company -> company.getCompanyId() == (id)).findFirst().ifPresent(companies::remove);
    }


    public List<Employee> getEmployeesByCompanyId(int companyId) {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getId() == companyId)
                .collect(Collectors.toList());
    }

    public List<Company> getByPage(Integer page, Integer pageSize) {
        return companies.stream()
                .skip((pageSize -1 ) * page)
                .limit(pageSize)
                .collect(Collectors.toList());
    }
}
