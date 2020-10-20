package com.mateuszjanczak.exception;

public class PlaceNotFoundException extends Throwable {
    public PlaceNotFoundException(int placeId) {
        super("Place not found, place number = " + placeId);
    }
}