package com.kodilla.spring.introduction.library;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryTestSuite {

    ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");

    @Test
    public void testLoadfromDb() {
        //Given
        Library library = context.getBean(Library.class);
        //When
        library.loadFromDb();
        //Then
    }

    @Test
    public void testSaveToDb() {
        //Given
        Library library = context.getBean(Library.class);
        //When
        library.saveToDb();
        //Then
    }

}
