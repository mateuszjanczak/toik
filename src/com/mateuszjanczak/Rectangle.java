package com.mateuszjanczak;

public class Rectangle extends Square {

    protected float b;

    public Rectangle(float a, float b) {
        super(a);
        this.name = "Rectangle";
        this.b = b;
    }

    @Override
    float calculateArea() {
        return this.a * this.b;
    }
}
