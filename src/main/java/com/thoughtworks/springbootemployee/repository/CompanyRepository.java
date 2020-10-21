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
        return null;
    }
}
