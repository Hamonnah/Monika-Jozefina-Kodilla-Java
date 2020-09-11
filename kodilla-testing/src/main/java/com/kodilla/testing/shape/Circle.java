package com.kodilla.testing.shape;

public class Circle implements Shape {

    private final double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public void getShapeName() {
        System.out.println("Circle");
    }

    @Override
    public double getField() {
        return Math.PI * r;
    }
}
