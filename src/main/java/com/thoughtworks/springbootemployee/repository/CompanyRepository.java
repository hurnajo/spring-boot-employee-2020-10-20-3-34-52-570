package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {
    private final List<Company> companies = new ArrayList<>();

    public List<Company> findAll() {
        return companies;
    }
}
