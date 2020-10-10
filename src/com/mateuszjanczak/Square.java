package com.mateuszjanczak;

public class Square extends Figure {

    protected float a;

    public Square(float a) {
        this.name = "Square";
        this.a = a;
    }

    @Override
    float calculateArea() {
        return this.a * this.a;
    }
}
