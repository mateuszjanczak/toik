package com.mateuszjanczak;

public class QuizImpl implements Quiz {

    private final int digit;

    public QuizImpl() {
        this.digit = 254;
    }

    @Override
    public void isCorrectValue(int value) throws ParamTooLarge, ParamTooSmall {
        if(value > digit) {
            throw new ParamTooLarge();
        } else if(value < digit) {
            throw new ParamTooSmall();
        }
    }
}
