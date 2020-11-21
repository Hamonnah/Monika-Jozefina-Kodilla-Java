package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    public CompanyFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompanies(String chars) {

        List<Company> companies = companyDao.retrieveCompanyWithChars(chars);
        LOGGER.info("Searching with phrase: " + chars);
        if (companies.size() == 0) {
            LOGGER.info("There are no companies that match the search: " + chars);
        }
        for (Company company : companies) {
            LOGGER.info("Companies that matches the search: " + company.getName());
        }
        return companies;
    }

    public List<Employee> findEmployees(String chars) {

        List<Employee> employees = employeeDao.retrieveEmployeeWithChars(chars);
        LOGGER.info("Searching with : " + chars);
        if (employees.size() == 0) {
            LOGGER.info("There are no companies that match the search: " + chars);
        }
        for (Employee employee : employees) {
            LOGGER.info("Company that matches the search phrase: " + employee.getLastname());
        }
        return employees;
    }

}
