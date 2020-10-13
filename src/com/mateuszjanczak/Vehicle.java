package com.mateuszjanczak;

enum Rotation {
    LEFT, RIGHT
}

enum Angle {

    _90(90), _180(180), _270(270);

    private final int id;
    Angle(int id) { this.id = id; }
    public int getValue() { return id; }
}

public interface Vehicle {
    void forward(int fields);
    void backward(int fields);
    void rotate(Rotation rotation, Angle angle);
    Position getCoordinates();
}
