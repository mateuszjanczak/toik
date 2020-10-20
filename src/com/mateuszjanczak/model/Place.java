package com.mateuszjanczak.model;

import com.mateuszjanczak.service.PlaneReservation;

public class Place {
    private int id;
    private String username;
    private PlaneReservation.PlaceType placeType;

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", placeType=" + placeType +
                '}';
    }

    public Place(int id, PlaneReservation.PlaceType placeType) {
        this.id = id;
        this.placeType = placeType;
    }

    public Place(int id, String username, PlaneReservation.PlaceType placeType) {
        this.id = id;
        this.username = username;
        this.placeType = placeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PlaneReservation.PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaneReservation.PlaceType placeType) {
        this.placeType = placeType;
    }
}