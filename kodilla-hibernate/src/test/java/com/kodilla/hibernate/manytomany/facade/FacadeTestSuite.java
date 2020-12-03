package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeTestSuite {

    @Autowired
    CompanyFacade companyFacade;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    CompanyDao companyDao;

    @Test
    public void employeeSearchByCharTest() {

        //Given
        Employee employee = new Employee("John", "Lemon");
        employeeDao.save(employee);

        //When
        List<Employee> employees = companyFacade.findEmployeeByChars("Lem");

        //Then
        try {
            Assert.assertEquals(1, employees.size());
        } finally {
            employeeDao.deleteAll();
        }
    }

    @Test
    public void companySearchByCharTest() {

        //Given
        Company company = new Company("Kodilla");
        companyDao.save(company);

        //When
        List<Company> companies = companyFacade.findCompaniesByChars("Kod");

        //Then
        try {
        Assert.assertEquals(1, companies.size());
        } finally {
            companyDao.deleteAll();
        }
    }

}
