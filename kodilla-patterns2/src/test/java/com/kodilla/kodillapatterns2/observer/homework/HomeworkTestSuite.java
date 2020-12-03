package com.kodilla.kodillapatterns2.observer.homework;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class HomeworkTestSuite {

    @Test
    public void testObserver() {

        //Given
        ExercisesQueue exerciseOne = new ExerciseOne();
        ExercisesQueue exerciseTwo = new ExerciseTwo();

        Mentor monikaBe = new Mentor("Monika Be");
        Mentor filipMar = new Mentor("Filip Mar");

        exerciseOne.registerObserver(monikaBe);
        exerciseOne.registerObserver(filipMar);
        exerciseTwo.registerObserver(monikaBe);

        //When
        exerciseOne.addExercise("Answer to exercise 1.1");
        exerciseOne.addExercise("Answer to exercise 1.2");
        exerciseOne.addExercise("Answer to exercise 1.3");
        exerciseTwo.addExercise("Answer to exercise 1.4");
        exerciseTwo.addExercise("Answer to exercise 1.5");

        //Then
        Assert.assertEquals(3, filipMar.getCount());
        Assert.assertEquals(5, monikaBe.getCount());

    }

}
