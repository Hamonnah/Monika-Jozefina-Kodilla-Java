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
    public void employeeSearchByCharTest() throws CompanySearchingException {

        //Given
        Employee employee = new Employee("John", "Lemon");
        Company company = new Company("Kodilla");
        //employeeDao.save();
        companyDao.save(company);

    }

    @Test
    public void companySearchByCharTest() throws CompanySearchingException {

        //Given
        Company company = new Company("Kodilla");
        companyDao.save(company);

        //When
        List<Company> companies = companyFacade.findCompanieByChars("Kod");

        //Then
        Assert.assertEquals(1,companies.size());

        //CleanUp
        companyDao.deleteAll();
    }
}
