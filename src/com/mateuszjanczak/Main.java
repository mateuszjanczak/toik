package com.mateuszjanczak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Zadanie 1

        List<Integer> list1 = lottery(Arrays.asList(1, 2, 3, 1, 1, 3, 3), 3);

        if (list1.equals(Arrays.asList(1, 3)))
            System.out.println("list1 OK");

        List<Integer> list2 = lottery(Arrays.asList(1, 1, 2, 2, 2, 3, 4, 5), 2);

        if (list2.equals(Collections.singletonList(1)))
            System.out.println("list2 OK");

        List<Integer> list3 = lottery(Arrays.asList(1,1,2,2,2,3,4,5), 3);

        if (list3.equals(Collections.singletonList(2)))
            System.out.println("list3 OK");

        List<Integer> list4 = lottery(Arrays.asList(1,1,2,2,2,3,4,5,5), 2);

        if (list4.equals(Arrays.asList(1,5)))
            System.out.println("list4 OK");

        List<Integer> list5 = lottery(null, 1);

        if (list5.equals(Collections.emptyList()))
            System.out.println("list5 OK");

        List<Integer> list6 = lottery(Arrays.asList(1,2,3), null);

        if (list6.equals(Collections.emptyList()))
            System.out.println("list6 OK");

        List<Integer> list7 = lottery(null, null);
        if (list7.equals(Collections.emptyList()))
            System.out.println("list7 OK");

        List<Integer> list8 = lottery(Arrays.asList(1,1,2,2,2,3,4,5), 7);
        if (list8.equals(Collections.emptyList()))
            System.out.println("list8 OK");

        // Zadanie 2

        Corsa corsa = new Corsa(new Position(0, 0, Direction.NORTH));
        corsa.rotate(Rotation.RIGHT, Angle._90);
        corsa.forward(2);
        corsa.rotate(Rotation.LEFT, Angle._90);
        corsa.backward(2);
        corsa.rotate(Rotation.RIGHT, Angle._90);
        corsa.backward(2);
        corsa.rotate(Rotation.LEFT, Angle._90);
        corsa.forward(1);
        System.out.println(corsa.getCoordinates());
    }

    private static List<Integer> lottery(List<Integer> collections, Integer digit) {
        if(collections == null || digit == null) return Collections.emptyList();

        ArrayList<Integer> list = new ArrayList<>();

        collections
                .stream()
                .distinct()
                .collect(Collectors.toList())
                .forEach(number -> {
                    if(Collections.frequency(collections, number) == digit) list.add(number);
                });

        return list;
    }
}
