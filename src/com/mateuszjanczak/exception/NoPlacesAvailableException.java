package com.mateuszjanczak.exception;

public class NoPlacesAvailableException extends Throwable {
    public NoPlacesAvailableException() {
        super("No places available");
    }
}