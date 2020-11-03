package com.kodilla.hibernate.manytomany.facade;

public class CompanySearchingException extends Exception {

    public static String ERR_EMPLOYEE_NOT_FOUND = "A string was provided with characters that are not available in the database for Employee ";
    public static String ERR_COMPANY_NOT_FOUND = "A string was provided with characters that are not available in the database for Company ";

    public CompanySearchingException(String message) {
        super(message);
    }

}
