package com.mateuszjanczak.toik_lab_11.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private int movieId;
    private String title;
    private int year;
    private String image;
}
