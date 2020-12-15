package com.mateuszjanczak.toik_lab_11.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto implements Serializable {
    private int movieId;
    private String title;
    private int year;
    private String image;
}
