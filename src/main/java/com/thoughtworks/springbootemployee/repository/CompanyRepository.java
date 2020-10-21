package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {
    private List<Company> companies = new ArrayList<>();

    public CompanyRepository(List<Company> companies) {
        this.companies = companies;
    }

    public List<Company> findAll() {
        return companies;
    }

    public Company save(Company company) {
        companies.add(company);
        return company;
    }

    public Company findById(Integer companyId) {
        return companies.stream().filter(company -> company.getId() == companyId).findFirst().orElse(null);
    }

    public Company updateById(Integer id, Company updatedCompany) {
        companies.stream().filter(company -> company.getId() == id).findFirst().ifPresent(employee -> {
            companies.remove(employee);
            companies.add(updatedCompany);
        });
        return updatedCompany;
    }

    public void deleteById(Integer id) {
        companies.stream().filter(company -> company.getId() == (id)).findFirst().ifPresent(companies::remove);
    }
}
