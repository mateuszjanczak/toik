package com.mateuszjanczak.service;

import com.mateuszjanczak.exception.*;
import com.mateuszjanczak.model.Place;

import java.util.List;

public interface PlaneReservation  {

    enum PlaceType {
        STANDARD,
        VIP
    }

    Place reservation(final PlaceType placeType, final String username, int price) throws NoPlacesAvailableException, IncorrectAmountOfMoneyException;
    int cancel(int placeId) throws PlaceNotFoundException;
    int status();
    List<Place> freePlaces();
    List<Place> reservedPlaces();
    boolean changePlaces(int sourcePlaceId, int destinationPlaceId) throws PlaceNotFoundException, PlaceIsTakenException, PlaceTypeConflictException;
}