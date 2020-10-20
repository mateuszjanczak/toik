package com.mateuszjanczak.exception;

public class IncorrectAmountOfMoneyException extends Throwable {
    public IncorrectAmountOfMoneyException(int needed, int given) {
        super("You need " + needed + "$, but you given " + given + "$");
    }
}