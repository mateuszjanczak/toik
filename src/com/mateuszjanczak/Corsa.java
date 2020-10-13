package com.mateuszjanczak;

public class Corsa implements Vehicle {

    private Position position;
    private int angle;

    public Corsa(Position position) {
        this.position = position;
    }

    private void run(int fields) {
        switch (position.getDirection()){
            case NORTH -> this.position.setY(position.getY() + fields);
            case SOUTH -> this.position.setY(position.getY() - fields);
            case EAST -> this.position.setX(position.getX() + fields);
            case WEST -> this.position.setX(position.getX() - fields);
        }
    }

    private void verifyDirection() {
        switch (this.angle) {
            case 0, 360 -> this.position.setDirection(Direction.NORTH);
            case 90, -270 -> this.position.setDirection(Direction.EAST);
            case 180, -180 -> this.position.setDirection(Direction.SOUTH);
            case 270, -90 -> this.position.setDirection(Direction.WEST);
        }
    }

    @Override
    public void forward(int fields) {
        run(fields);
    }

    @Override
    public void backward(int fields) {
        run(-fields);
    }

    @Override
    public void rotate(Rotation rotation, Angle angle) {
        switch (rotation) {
            case LEFT -> this.angle -= angle.getValue();
            case RIGHT -> this.angle += angle.getValue();
        }

        if(this.angle == 360 || this.angle == -360) this.angle = 0;

        if(this.angle > 360) this.angle -= 360;

        if(this.angle < -360) this.angle += 360;

        verifyDirection();
    }

    @Override
    public Position getCoordinates() {
        return position;
    }

}
