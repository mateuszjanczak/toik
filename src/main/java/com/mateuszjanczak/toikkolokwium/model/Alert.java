package com.mateuszjanczak.toikkolokwium.model;

import java.util.List;

public class Alert {
    List<String> alert;

    public Alert() {
    }

    public Alert(List<String> alert) {
        this.alert = alert;
    }

    public List<String> getAlert() {
        return alert;
    }

    public void setAlert(List<String> alert) {
        this.alert = alert;
    }
}

