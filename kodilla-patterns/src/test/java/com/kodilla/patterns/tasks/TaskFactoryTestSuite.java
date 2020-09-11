package com.kodilla.patterns.tasks;

import com.kodilla.patterns.factory.tasks.Task;
import com.kodilla.patterns.factory.tasks.TaskFactory;
import com.kodilla.patterns.factory.tasks.TaskType;
import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    //Given
    TaskFactory taskFactory = new TaskFactory();

    @Test
    public void testFactoryShopping() {
        //When
        Task shopping = taskFactory.createTask(TaskType.SHOPPING);
        shopping.executeTask();
        //Then
        Assert.assertEquals("Shopping", shopping.getTaskName());
        Assert.assertTrue(shopping.isTaskExecuted());

    }

    @Test
    public void testFactoryDriving() {
        //When
        Task driving = taskFactory.createTask(TaskType.DRIVING);
        driving.executeTask();
        //Then
        Assert.assertEquals("Driving", driving.getTaskName());
        Assert.assertTrue(driving.isTaskExecuted());
    }

    @Test
    public void testFactoryPainting() {
        //When
        Task painting = taskFactory.createTask(TaskType.PAINTING);
        painting.executeTask();
        //Then
        Assert.assertEquals("Painting", painting.getTaskName());
        Assert.assertTrue(painting.isTaskExecuted());
    }

}
