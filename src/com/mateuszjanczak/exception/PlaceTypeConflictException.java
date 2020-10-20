package com.mateuszjanczak.exception;

import com.mateuszjanczak.service.PlaneReservation;

public class PlaceTypeConflictException extends Throwable {
    public PlaceTypeConflictException(PlaneReservation.PlaceType needed, PlaneReservation.PlaceType given) {
        super("You need " + needed + " place type, but you given " + given + " place type");
    }
}