package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User user = new Millenials("Andzelika");
        User user1 = new ZGeneration("Zosia");
        User user2 = new YGeneration("Quentinek");
        //When
        String userShareOn = user.sharePost();
        String user1ShareOn = user1.sharePost();
        String user2ShareOn = user2.sharePost();
        //Then
        Assert.assertEquals("Facebook", userShareOn);
        Assert.assertEquals("Twitter", user1ShareOn);
        Assert.assertEquals("Snapchat", user2ShareOn);
    }

    @Test
    public void  testIndividualSharingStrategy() {
        //Given
        User user = new Millenials("Andzelika");
        //When
        user.setSocialPublisher(new TwitterPublisher());
        String userUsedNewMedia = user.sharePost();
        //Then
        Assert.assertEquals("Twitter", userUsedNewMedia );
    }

}
