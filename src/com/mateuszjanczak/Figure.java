package com.mateuszjanczak;

public abstract class Figure {

    protected String name;

    @Override
    public String toString() {
        return "Figure name: " + this.name;
    }

    abstract float calculateArea();
}
