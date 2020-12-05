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
        Employee employee1 = new Employee("Johanna", "Lemoniada");
        Employee employee2 = new Employee("Karol", "Kolinsky");
        Employee employee3 = new Employee("Adrianna", "Fuks");
        employeeDao.save(employee);
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        //When
        List<Employee> employees = companyFacade.findEmployeeByChars("Lem");

        //Then
        try {
            Assert.assertEquals(2, employees.size());
        } finally {
            employeeDao.deleteAll();
        }
    }

    @Test
    public void companySearchByCharTest() {

        //Given
        Company company = new Company("Kodilla");
        Company company1 = new Company("KodOn");
        Company company2 = new Company("Dentinor");
        Company company3 = new Company("Maur");
        companyDao.save(company);
        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        //When
        List<Company> companies = companyFacade.findCompaniesByChars("Kod");

        //Then
        try {
            Assert.assertEquals(2, companies.size());
        } finally {
            companyDao.deleteAll();
        }
    }

}
