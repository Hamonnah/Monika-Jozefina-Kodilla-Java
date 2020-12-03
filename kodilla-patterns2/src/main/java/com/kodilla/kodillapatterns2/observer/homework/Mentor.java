package com.kodilla.kodillapatterns2.observer.homework;

public class Mentor  implements Observer {

    private final String mentorName;
    private int count;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void update(ExercisesQueue exercisesQueue) {
        System.out.println (mentorName + ", new exercise to check: " + exercisesQueue.getName());
        count++;
    }

}
