package com.demo.springboot.service.impl;

import com.demo.springboot.dto.MovieRequest;
import com.demo.springboot.exception.EmptyDtoException;
import com.demo.springboot.exception.MovieNotFoundException;
import com.demo.springboot.model.Movie;
import com.demo.springboot.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final ArrayList<Movie> movieList;

    public MovieServiceImpl() {
        this.movieList = new ArrayList<>();
    }

    @Override
    public List<Movie> findAll() {
        Collections.reverse(movieList);
        return movieList;
    }

    @Override
    public Movie create(MovieRequest movieRequest) throws EmptyDtoException {

        if(movieRequest.getImage() == null || movieRequest.getTitle() == null || movieRequest.getYear() == null){
            throw new EmptyDtoException();
        }

        Movie movie = new Movie();
        movie.setMovieId(movieList.size() + 1);
        movie.setImage(movieRequest.getImage());
        movie.setTitle(movieRequest.getTitle());
        movie.setYear(movieRequest.getYear());
        movieList.add(movie);
        return movie;
    }

    @Override
    public Movie update(MovieRequest movieRequest, int id) throws MovieNotFoundException {
        return movieList.stream()
                .filter(movie -> movie.getMovieId().equals(id))
                .peek(movie -> {
                    movie.setTitle(movieRequest.getTitle());
                    movie.setYear(movieRequest.getYear());
                    movie.setImage(movieRequest.getImage());
                })
                .findFirst()
                .orElseThrow(() -> new MovieNotFoundException(String.valueOf(id)));
    }

    @Override
    public void delete(int id) throws MovieNotFoundException {
        movieList.remove (
                movieList.stream()
                        .filter(movie -> movie.getMovieId().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new MovieNotFoundException(String.valueOf(id)))
        );
    }
}
