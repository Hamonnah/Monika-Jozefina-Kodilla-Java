package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    Employee johnSmith = new Employee("John", "Smith");
    Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
    Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
    Employee johnClarckson = new Employee("John", "Clarckson");
    Employee hannaMontana = new Employee("Hanna", "Montana");

    Company softwareMachine = new Company("Software Machine");
    Company dataMaesters = new Company("Data Maesters");
    Company greyMatter = new Company("Grey Matter");
    Company greyZone = new Company("Grey Zone");
    Company gregorysSoftware = new Company("Gregorys Software");

    @Test
    public void testSaveManyToMany(){
        //Given
        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
           companyDao.deleteById(softwareMachineId);
           companyDao.deleteById(dataMaestersId);
           companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
        //do nothing
        }
    }

    @Test
    public void testRetrieveEmployeeWithLastname() {

        //When
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        employeeDao.save(johnClarckson);
        employeeDao.save(hannaMontana);

        List<Employee>employeesByLastName = employeeDao.retrieveEmployeeWithLastname("Clarckson");

        //CleanUp
        employeeDao.deleteAll();

        //Then
        Assert.assertEquals(2, employeesByLastName.size());
    }

    @Test
    public void testRetrieveNameCompanyForFirstThreeChar() {

        //When
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
        companyDao.save(greyZone);
        companyDao.save(gregorysSoftware);

        List<Company>copaniesByThereFirstChar = companyDao.retrieveCompanyWithNameStartingWithThreeChars("gre");

        //CleanUp
        companyDao.deleteAll();

        //Then
        Assert.assertEquals(3, copaniesByThereFirstChar.size());
    }

}