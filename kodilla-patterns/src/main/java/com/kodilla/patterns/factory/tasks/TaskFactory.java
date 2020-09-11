package com.kodilla.patterns.factory.tasks;

public class TaskFactory {


    public final Task createTask(final TaskType taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Shopping", "bread", 3);
            case PAINTING:
                return new PaintingTask("Painting", "pink", "Walls2Paint");
            case DRIVING:
                return new DrivingTask("Driving", "Poland", "Porsche" );
            default: return null;
        }
    }

}
