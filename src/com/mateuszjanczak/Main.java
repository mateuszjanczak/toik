package com.mateuszjanczak;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Zadanie 1
        printTriangle();

        // Zadanie 2
        Double averageResult = average(Arrays.asList(1.0, 2.0, 3.0));
        System.out.println("avg = " + averageResult);

        // Zadanie 3
        showArea(new Square(4.0f));             // 16.0
        showArea(new Rectangle(4.0f, 2.0f));    // 8.0
        showArea(new Triangle(4.0f, 2.0f));
    }

    public static void printTriangle() {
        final int size = 4;
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(j == 0 || j == i || i == size - 1) {
                    System.out.print("o");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static Double average(List<Double> digits) {
        return digits.stream().reduce(0.0, Double::sum) / digits.size();
    }

    private static void showArea(final Figure figure) {
        System.out.println("Area: " + figure.calculateArea());
    }
}
