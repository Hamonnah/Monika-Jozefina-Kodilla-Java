package com.kodilla.patterns.singleton;

import com.kodilla.patterns.singleton.singleton.Logger;
import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("Hehihi");
        //When
        String lastLog = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("Hehihi", lastLog);
    }

}
