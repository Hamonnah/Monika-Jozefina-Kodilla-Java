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

    public List<Company> listOfCompanies(CompanyDao companyDao, String threeChars)
            throws CompanySearchingException {
        boolean wasError = false;
        List<Company> companies =
                companyDao.retrieveCompanyWithTreeChars(threeChars);
        try {
            LOGGER.info("Searching with phrase: " + threeChars);
            if (companies.size() < 0) {
                LOGGER.info("There are no companies that match the search: " + threeChars);
                wasError = true;
                throw new CompanySearchingException(CompanySearchingException.ERR_COMPANY_NOT_FOUND);
            }
            for (Company company : companies) {
                LOGGER.info("Companies that matches the search: " + company.getName());
            }
        } finally {
            if (wasError) {
                LOGGER.info("Company is not found");
            }
        }
        return companies;
    }

    public List<Employee> listOfEmloyees(EmployeeDao employeeDao, String threeChars)
            throws CompanySearchingException {
        boolean wasError = false;
        List<Employee> employees =
                employeeDao.retrieveEmployeeWithThreeChars(threeChars);
        try {
            LOGGER.info("Searching with : " + threeChars);
            if (employees.size() < 0) {
                LOGGER.error("There are no companies that match the search: " + threeChars,
                        CompanySearchingException.ERR_EMPLOYEE_NOT_FOUND);
                wasError = true;
                throw new CompanySearchingException(CompanySearchingException.ERR_EMPLOYEE_NOT_FOUND);
            }
            for (Employee employee : employees) {
                LOGGER.info("Company that matches the search phrase: " + employee.getLastname());
            }
        } finally {
            if (wasError) {
                LOGGER.info("Employee is not found");
            }
        }
        return employees;

    }

}
