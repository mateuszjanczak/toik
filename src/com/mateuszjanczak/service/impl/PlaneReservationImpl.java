package com.mateuszjanczak.service.impl;

import com.mateuszjanczak.exception.*;
import com.mateuszjanczak.model.Place;
import com.mateuszjanczak.service.PlaneReservation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlaneReservationImpl implements PlaneReservation {

    private final ArrayList<Place> placeList;

    public PlaneReservationImpl() {
        placeList = new ArrayList<>();
        IntStream.range(1, 101)
                .forEach(i -> placeList.add(new Place(i, PlaceType.STANDARD)));
        IntStream.range(101, 129)
                .forEach(i -> placeList.add(new Place(i, PlaceType.VIP)));
    }

    @Override
    public Place reservation(PlaceType placeType, String username, int price) throws NoPlacesAvailableException, IncorrectAmountOfMoneyException {
        int cost = getPrice(placeType);
        if(cost > price) throw new IncorrectAmountOfMoneyException(cost, price);

        Place place = placeList.stream()
                .filter(item -> item.getPlaceType().equals(placeType) && item.getUsername() == null)
                .findFirst()
                .orElseThrow(NoPlacesAvailableException::new);

        place.setPlaceType(placeType);
        place.setUsername(username);

        return place;
    }

    @Override
    public int cancel(int placeId) throws PlaceNotFoundException {
        Place place = placeList.stream()
                .filter(item -> item.getId() == placeId)
                .findFirst()
                .orElseThrow(() -> new PlaceNotFoundException(placeId));

        place.setUsername(null);
        place.setPlaceType(null);

        return place.getId();
    }

    @Override
    public int status() {
        return placeList.stream()
                .filter(item -> item.getUsername() != null)
                .map(item -> getPrice(item.getPlaceType()))
                .reduce(0, Integer::sum);
    }

    @Override
    public List<Place> freePlaces() {
        return placeList.stream()
                .filter(item -> item.getUsername() == null)
                .collect(Collectors.toList());
    }

    @Override
    public List<Place> reservedPlaces() {
        return placeList.stream()
                .filter(item -> item.getUsername() != null)
                .collect(Collectors.toList());
    }

    @Override
    public boolean changePlaces(int sourcePlaceId, int destinationPlaceId) throws PlaceNotFoundException, PlaceIsTakenException, PlaceTypeConflictException {
        Place sourcePlace = placeList.stream()
                .filter(item -> item.getId() == sourcePlaceId)
                .findFirst()
                .orElseThrow(() -> new PlaceNotFoundException(sourcePlaceId));

        Place destinationPlace = placeList.stream()
                .filter(item -> item.getId() == destinationPlaceId)// && item.getUsername() == null && item.getPlaceType().equals(sourcePlace.getPlaceType()))
                .findFirst()
                .orElseThrow(() -> new PlaceNotFoundException(sourcePlaceId));

        if(destinationPlace.getUsername() != null) throw new PlaceIsTakenException(destinationPlaceId);
        if(!destinationPlace.getPlaceType().equals(sourcePlace.getPlaceType())) throw new PlaceTypeConflictException(destinationPlace.getPlaceType(), sourcePlace.getPlaceType());

        destinationPlace.setUsername(sourcePlace.getUsername());
        destinationPlace.setPlaceType(sourcePlace.getPlaceType());

        sourcePlace.setUsername(null);
        sourcePlace.setPlaceType(null);

        return true;
    }

    private int getPrice(PlaceType placeType) {
        return PlaceType.STANDARD.equals(placeType) ? 800 : 1200;
    }
}