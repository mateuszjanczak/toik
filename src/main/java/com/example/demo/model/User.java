package com.example.demo.model;

public class User {

    private String login;
    private String password;
    private boolean active;
    int incorrectLoginCounter;

    public User(String login, String password, boolean active, int incorrectLoginCounter) {
        this.login = login;
        this.password = password;
        this.active = active;
        this.incorrectLoginCounter = incorrectLoginCounter;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", incorrectLoginCounter=" + incorrectLoginCounter +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }

    public int getIncorrectLoginCounter() {
        return incorrectLoginCounter;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setIncorrectLoginCounter(int incorrectLoginCounter) {
        this.incorrectLoginCounter = incorrectLoginCounter;
    }
}
