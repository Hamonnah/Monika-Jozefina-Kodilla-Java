package com.kodilla.hibernate.manytomany.facade;

public class CompanySearchingException extends Exception {

    public static String ERR_EMPLOYEE_NOT_FOUND = "An employee with name containing provided characters not found ";
    public static String ERR_COMPANY_NOT_FOUND = "An company with name containing provided characters not found ";

    public CompanySearchingException(String message) {
        super(message);
    }

}
