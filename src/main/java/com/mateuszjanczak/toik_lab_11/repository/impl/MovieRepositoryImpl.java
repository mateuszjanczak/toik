package com.mateuszjanczak.toik_lab_11.repository.impl;

import com.mateuszjanczak.toik_lab_11.model.Movie;
import com.mateuszjanczak.toik_lab_11.repository.MovieRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    private final List<Movie> movieList;

    public MovieRepositoryImpl() {
        movieList = new ArrayList<>();
        movieList.add(Movie.builder().movieId(1).title("Piraci z krzemowej doliny").image("https://fwcdn.pl/fpo/30/02/33002/6988507.3.jpg").year(1999).build());
        movieList.add(Movie.builder().movieId(2).title("Piraci z czerwonej doliny").image("https://fwcdn.pl/fpo/30/02/33002/6988507.3.jpg").year(2010).build());
        movieList.add(Movie.builder().movieId(3).title("Piraci z niebieskiej doliny").image("https://fwcdn.pl/fpo/30/02/33002/6988507.3.jpg").year(2020).build());
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
