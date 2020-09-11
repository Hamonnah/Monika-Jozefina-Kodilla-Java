package com.kodilla.spring.introduction.shape;

import org.springframework.context.annotation.Configuration;

public class Square implements Shape {
    @Override
    public String getShapeName() {
        return "This is a square.";
    }

}
