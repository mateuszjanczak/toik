package com.mateuszjanczak;

public interface Quiz {

    int MIN_VALUE = 0;
    int MAX_VALUE = 1000;

    void isCorrectValue(int value)
            throws Quiz.ParamTooLarge, Quiz.ParamTooSmall;

    class ParamTooLarge extends Exception {}
    class ParamTooSmall extends Exception {}
}