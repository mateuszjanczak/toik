package com.mateuszjanczak.toik_lab_11.repository;

import com.mateuszjanczak.toik_lab_11.model.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getMovieList();
}
