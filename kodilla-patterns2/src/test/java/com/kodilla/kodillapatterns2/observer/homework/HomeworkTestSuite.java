package com.kodilla.kodillapatterns2.observer.homework;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class HomeworkTestSuite {

    @Test
    public void testObserver() {

        //Given
        ExercisesQueue piotrNowakExercises = new ExerciseOne();
        ExercisesQueue janKowalskiExercises = new ExerciseTwo();

        Mentor monikaBe = new Mentor("Monika Be");
        Mentor filipMar = new Mentor("Filip Mar");

        piotrNowakExercises.registerObserver(monikaBe);
        piotrNowakExercises.registerObserver(filipMar);
        janKowalskiExercises.registerObserver(monikaBe);

        //When
        piotrNowakExercises.addExercise("Answer to exercise 1.1");
        piotrNowakExercises.addExercise("Answer to exercise 1.2");
        piotrNowakExercises.addExercise("Answer to exercise 1.3");
        janKowalskiExercises.addExercise("Answer to exercise 1.4");
        janKowalskiExercises.addExercise("Answer to exercise 1.5");

        //Then
        Assert.assertEquals(3, filipMar.getCount());
        Assert.assertEquals(5, monikaBe.getCount());
    }

}
