package com.mateuszjanczak;

import com.mateuszjanczak.exception.*;
import com.mateuszjanczak.service.PlaneReservation;
import com.mateuszjanczak.service.impl.PlaneReservationImpl;

public class Main {

    public static void main(String[] args) {
	    PlaneReservationImpl planeReservation = new PlaneReservationImpl();
        try {
            planeReservation.reservation(PlaneReservation.PlaceType.VIP, "Kornel", 1234);
            planeReservation.reservation(PlaneReservation.PlaceType.VIP, "Patryk", 1234);
            planeReservation.reservation(PlaneReservation.PlaceType.VIP, "Mateusz", 1234);
            planeReservation.reservation(PlaneReservation.PlaceType.STANDARD, "Aleksander", 1234);
            planeReservation.reservation(PlaneReservation.PlaceType.STANDARD, "Szymon", 1234);
            planeReservation.reservation(PlaneReservation.PlaceType.STANDARD, "Andrzej", 1234);
            planeReservation.reservation(PlaneReservation.PlaceType.STANDARD, "Przemek", 1234);
            planeReservation.status();
            planeReservation.freePlaces().forEach(System.out::println);
            planeReservation.reservedPlaces().forEach(System.out::println);
            planeReservation.changePlaces(1, 53);
            planeReservation.reservedPlaces().forEach(System.out::println);
            planeReservation.cancel(53);
            planeReservation.reservedPlaces().forEach(System.out::println);
        } catch (NoPlacesAvailableException | IncorrectAmountOfMoneyException | PlaceNotFoundException | PlaceIsTakenException | PlaceTypeConflictException e) {
            System.out.println(e.getMessage());
        }
    }
}