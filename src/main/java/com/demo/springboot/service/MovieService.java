package com.demo.springboot.service;

import com.demo.springboot.dto.MovieRequest;
import com.demo.springboot.exception.EmptyDtoException;
import com.demo.springboot.exception.MovieNotFoundException;
import com.demo.springboot.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie create(MovieRequest movieRequest) throws EmptyDtoException;
    Movie update(MovieRequest movieRequest, int id) throws MovieNotFoundException;
    void delete(int id) throws MovieNotFoundException;
}
