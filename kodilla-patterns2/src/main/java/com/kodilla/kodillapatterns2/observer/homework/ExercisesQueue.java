package com.kodilla.kodillapatterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ExercisesQueue implements Observable {

    private final List<Observer> mentors;
    private final Queue<String> exercisesQueue;
    private final String name;

    public ExercisesQueue(String name) {
        this.mentors = new ArrayList<>();
        this.exercisesQueue = new ArrayDeque<>();
        this.name = name;
    }

    public List<Observer> getMentors() {
        return mentors;
    }

    public Queue<String> getExercisesQueue() {
        return exercisesQueue;
    }

    public String getName() {
        return name;
    }

    @Override
    public void registerObserver(Observer observer) {
        mentors.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer mentor : mentors) {
            mentor.update(this);
        }
    }

    public void addExercise(String exercise) {
        exercisesQueue.add(exercise);
        notifyObserver();
    }

}
