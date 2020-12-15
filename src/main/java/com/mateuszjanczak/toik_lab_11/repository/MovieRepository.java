package com.mateuszjanczak.toik_lab_11.repository;

import java.util.List;

public interface MovieRepository {
    String PATH = "src/main/resources/movies.csv";
    List<String> getMovieList();
}
