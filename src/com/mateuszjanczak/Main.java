package com.mateuszjanczak;

public class Main {

    public static void main(String[] args) {
        Quiz quiz = new QuizImpl();

        int minValue = Quiz.MIN_VALUE;
        int maxValue = Quiz.MAX_VALUE;
        int digit = (maxValue - minValue) / 2;

        for(int counter = 1; ;counter++) {
            System.out.println(digit);
            try {
                quiz.isCorrectValue(digit);
                System.out.println("Trafiona proba!!! Szukana liczba to: " + digit + " Ilosc prob: " + counter);
                break;
            } catch (Quiz.ParamTooLarge paramTooLarge) {
                System.out.println("Argument za duzy!!!");
                maxValue = digit;
            } catch (Quiz.ParamTooSmall paramTooSmall) {
                System.out.println("Argument za maly!!!");
                minValue = digit;
            }
            digit = (maxValue + minValue) / 2;
        }
    }
}
