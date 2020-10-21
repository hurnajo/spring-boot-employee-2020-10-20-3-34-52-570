package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;

import java.util.List;

public class CompanyService {
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Company create(Company company) {
        return companyRepository.save(company);
    }

    public Company findById(Integer id) {
        return companyRepository.findById(id);
    }

    public Company updateById(Integer id, Company company) {
        return companyRepository.updateById(id,company);
    }

    public void deleteById(Integer id) {
        companyRepository.deleteById(id);
    }
}
