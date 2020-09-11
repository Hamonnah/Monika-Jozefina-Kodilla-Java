package com.kodilla.testing.shape;

public class Square implements Shape {

    private final double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public void getShapeName() {
        System.out.println("Square");
    }

    @Override
    public double getField() {
        return a * a;
    }
}
