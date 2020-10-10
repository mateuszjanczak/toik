package com.mateuszjanczak;

public class Triangle extends Figure {

    protected float a, h;

    public Triangle(float a, float h) {
        this.name = "Triangle";
        this.a = a;
        this.h = h;
    }

    @Override
    float calculateArea() {
        return 0.5f * this.a * this.h;
    }
}
