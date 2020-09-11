package com.kodilla.spring.introduction;

import com.kodilla.spring.introduction.forumUser.ForumUser;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class ForumUserTestSuite {

    @Test
    public void testForumGetUser() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.introduction.forumUser");
        ForumUser forumUser = context.getBean(ForumUser.class);
        //When
        String userName = forumUser.getUsername();
        //Then
        Assert.assertEquals("John Smith", userName);
    }

}
