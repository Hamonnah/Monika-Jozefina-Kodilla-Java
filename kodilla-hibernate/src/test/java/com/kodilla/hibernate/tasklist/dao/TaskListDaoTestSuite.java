package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String LISTNAME = "What ever";
    private static final String DESCRIPTION = "Do what ever you want";

    @Test
    public void testFindByListName() {

        //Given
        TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);
        taskListDao.save(taskList);

        //When
        List<TaskList> readTaskList = taskListDao.findByListName(LISTNAME);
        TaskList firstTaskList = readTaskList.get(0);

        //Then
        try {
            Assert.assertEquals(LISTNAME, firstTaskList.getListName());
            Assert.assertEquals(DESCRIPTION, firstTaskList.getDescription());
            Assert.assertEquals(1, readTaskList.size());
            Assert.assertNotNull(taskList.getId());
        } finally {
            taskListDao.deleteAll();
        }
    }

}
