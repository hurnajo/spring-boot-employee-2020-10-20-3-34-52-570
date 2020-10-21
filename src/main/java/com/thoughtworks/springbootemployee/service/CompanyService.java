package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return companyRepository.findCompanyById(id);
    }

    public Company updateById(Integer id, Company company) {
        return companyRepository.updateCompanyById(id, company);
    }

    public void deleteById(Integer id) {
        companyRepository.deleteById(id);
    }

    public List<Employee> getEmployeesByCompanyId(int companyId) {
        return companyRepository.getEmployeesByCompanyId(companyId);
    }

    public List<Company> getByPage(Integer page, Integer pageSize) {
        return companyRepository.getByPage(page,pageSize);
    }
}
