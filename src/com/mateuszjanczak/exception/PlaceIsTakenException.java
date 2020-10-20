package com.mateuszjanczak.exception;

public class PlaceIsTakenException extends Throwable {
    public PlaceIsTakenException(int placeId) {
        super("Place is taken by another user, place number = " + placeId);
    }
}