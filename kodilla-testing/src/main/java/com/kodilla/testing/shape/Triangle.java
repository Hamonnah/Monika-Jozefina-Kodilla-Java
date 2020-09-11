package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private final double a;
    private final double h;

    public Triangle(double a, double h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public void getShapeName() {
        System.out.println("Triangle");
    }

    @Override
    public double getField() {
        return 0.5 * a * h;
    }

}
