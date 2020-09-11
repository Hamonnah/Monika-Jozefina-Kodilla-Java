package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.NaN;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsTestSuite {

    private static int testCounter = 0;

    @Before
    public void beforeEveryTest() {

        testCounter++;
        System.out.println("\n" + "Test # " + testCounter + "\n");
    }

    @Test
    public void testStatisticsForZero() {

        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        usersNames.add("Brat Pit");
        usersNames.add("Angelina Joe");
        usersNames.add("Lauryn Hill");

        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();

        Assert.assertEquals(0, forumStatistics.avgPostPerUser, 0.01);
        Assert.assertEquals(0, forumStatistics.avgCommentPerUser, 0.01);
        Assert.assertEquals(NaN, forumStatistics.avgCommentPerPost, 0.01);
    }

    @Test
    public void testStatisticNoUser() {

        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();

        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();

        Assert.assertEquals(NaN, forumStatistics.avgPostPerUser, 0.01);
        Assert.assertEquals(NaN, forumStatistics.avgCommentPerUser, 0.01);
        Assert.assertEquals(NaN, forumStatistics.avgCommentPerPost, 0.01);
    }

    @Test
    public void testStatisticHundredUsers() {

        Statistics statisticsMock = mock(Statistics.class);

        List<String> usersNames = new ArrayList<>();
        for (int n = 0; n < 100; n++) {
            usersNames.add("User Name" + n);
        }

        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();

        Assert.assertEquals(1, forumStatistics.avgPostPerUser, 0.01);
        Assert.assertEquals(1, forumStatistics.avgCommentPerUser, 0.01);
        Assert.assertEquals(1, forumStatistics.avgCommentPerPost, 0.01);
    }

    @Test
    public void testStatisticsForThousand() {

        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        usersNames.add("Brat Pit");
        usersNames.add("Angelina Joe");
        usersNames.add("Lauryn Hill");

        when(statisticsMock.commentsCount()).thenReturn(138);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();

        Assert.assertEquals(333.33, forumStatistics.avgPostPerUser, 0.01);
        Assert.assertEquals(46, forumStatistics.avgCommentPerUser, 0.01);
        Assert.assertEquals(0.14, forumStatistics.avgCommentPerPost, 0.01);
    }

    @Test
    public void testStatisticsForLessCommentsThanPosts() {

        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        usersNames.add("Brat Pit");
        usersNames.add("Angelina Joe");
        usersNames.add("Lauryn Hill");


        when(statisticsMock.commentsCount()).thenReturn(1);
        when(statisticsMock.postsCount()).thenReturn(2);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();

        Assert.assertEquals(0.66, forumStatistics.avgPostPerUser, 0.01);
        Assert.assertEquals(0.33, forumStatistics.avgCommentPerUser, 0.01);
        Assert.assertEquals(0.5, forumStatistics.avgCommentPerPost, 0.01);
    }

    @Test
    public void testStatisticsForLessPostsThanComments() {

        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        usersNames.add("Brat Pit");
        usersNames.add("Angelina Joe");
        usersNames.add("Lauryn Hill");

        when(statisticsMock.commentsCount()).thenReturn(2);
        when(statisticsMock.postsCount()).thenReturn(1);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();

        Assert.assertEquals(0.33, forumStatistics.avgPostPerUser, 0.01);
        Assert.assertEquals(0.66, forumStatistics.avgCommentPerUser, 0.01);
        Assert.assertEquals(2, forumStatistics.avgCommentPerPost, 0.01);
    }

}
