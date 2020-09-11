package com.kodilla.spring.introduction.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Autowired
    Board board;

    @Test
    public void testTaskAdd() {

        //When
        board.getToDoList().getTasks().add("make diner");
        board.getInProgressList().getTasks().add("go for a shopping");
        board.getDoneList().getTasks().add("drink cafe");

        String toDoTask = board.getToDoList().getTasks().get(0);
        String inProgressTask = board.getInProgressList().getTasks().get(0);
        String doneTask = board.getDoneList().getTasks().get(0);
        //Then
        Assert.assertEquals("make diner", toDoTask );
        Assert.assertEquals("go for a shopping", inProgressTask);
        Assert.assertEquals("drink cafe", doneTask);
    }

}
